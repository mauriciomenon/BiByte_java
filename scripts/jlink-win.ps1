# Build a portable JRE (Windows) for Launch4j/jpackage.
# Output: out\win\jre
# Usage (PowerShell):
#   $env:JAVA_HOME="C:\\Program Files\\Eclipse Adoptium\\jdk-25"; ./scripts/jlink-win.ps1

$ErrorActionPreference = 'Stop'

if (-not $env:JAVA_HOME) { Write-Error "JAVA_HOME not set" }
$JMODS = Join-Path $env:JAVA_HOME 'jmods'
if (-not (Test-Path $JMODS)) { Write-Error "jmods not found at $JMODS" }

$DEST = 'out\\win\\jre'
New-Item -ItemType Directory -Force -Path $DEST | Out-Null

$MODULES = @(
  'java.base', 'java.datatransfer', 'java.desktop', 'java.logging', 'java.xml', 'java.prefs', 'java.naming', 'jdk.unsupported'
)

& jlink `
  --module-path $JMODS `
  --add-modules ($MODULES -join ',') `
  --no-header-files `
  --no-man-pages `
  --strip-debug `
  --compress=2 `
  --output $DEST

Write-Host "Portable JRE created at $DEST"

