# Build a small Windows .exe wrapper using Launch4j.
# Creates a temp config pointing to build\libs\BiByte-<VERSION>.jar and outputs to out\win.
# Uses a portable JRE folder named 'jre' next to the .exe if present.
#
# Usage (PowerShell): $env:VERSION="2.0.2"; ./scripts/launch4j-win.ps1

$ErrorActionPreference = 'Stop'

$VERSION = if ($env:VERSION) { $env:VERSION } else { 'dev' }
$APP_NAME = 'BiByte'
$JAR = "build\libs\$APP_NAME-$VERSION.jar"
$OUTDIR = 'out\win'
$OUTEXE = "$OUTDIR\$APP_NAME-$VERSION.exe"
$ICON = 'process-icon1.ico'

if (-not (Test-Path $JAR)) {
  Write-Error "Jar not found: $JAR. Run 'gradle build' or set VERSION correctly."
}

New-Item -ItemType Directory -Force -Path $OUTDIR | Out-Null

$LAUNCH4J = ${env:LAUNCH4J_EXE}
if (-not $LAUNCH4J) {
  # Common default install path
  $LAUNCH4J = "C:\\Program Files (x86)\\Launch4j\\launch4jc.exe"
}

if (-not (Test-Path $LAUNCH4J)) {
  Write-Error "Launch4j not found. Set LAUNCH4J_EXE env var or install via Chocolatey."
}

$temp = New-TemporaryFile
$xml = @"
<launch4jConfig>
  <dontWrapJar>false</dontWrapJar>
  <headerType>gui</headerType>
  <jar>$JAR</jar>
  <outfile>$OUTEXE</outfile>
  <priority>normal</priority>
  <downloadUrl>http://java.com/download</downloadUrl>
  <customProcName>false</customProcName>
  <stayAlive>false</stayAlive>
  <icon>$ICON</icon>
  <jre>
    <path>jre</path>
    <minVersion>1.8.0</minVersion>
    <jdkPreference>preferJre</jdkPreference>
  </jre>
</launch4jConfig>
"@
$xml | Set-Content -Path $temp.FullName -Encoding UTF8

& "$LAUNCH4J" "$($temp.FullName)"

Write-Host "Launch4j .exe generated: $OUTEXE"

