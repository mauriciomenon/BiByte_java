# Build a small Windows .exe wrapper using Launch4j.
# Requires Launch4j installed (e.g., `choco install launch4j`) and bitbyte_Launch4j.xml in repo root.

$ErrorActionPreference = 'Stop'

$LAUNCH4J = ${env:LAUNCH4J_EXE}
if (-not $LAUNCH4J) {
  # Common default install path
  $LAUNCH4J = "C:\Program Files (x86)\Launch4j\launch4jc.exe"
}

if (-not (Test-Path $LAUNCH4J)) {
  Write-Error "Launch4j not found. Set LAUNCH4J_EXE env var or install via Chocolatey."
}

$CONFIG = "bitbyte_Launch4j.xml"
if (-not (Test-Path $CONFIG)) {
  Write-Error "Missing $CONFIG in repo root."
}

& "$LAUNCH4J" "$CONFIG"

Write-Host "Launch4j .exe generated per $CONFIG"

