# Windows EXE packaging using jpackage.
# Usage (PowerShell): $env:VERSION="2.0.2"; ./scripts/jpackage-win-exe.ps1

$ErrorActionPreference = 'Stop'

$VERSION = if ($env:VERSION) { $env:VERSION } else { 'dev' }
$APP_NAME = 'BiByte'
$MAIN_CLASS = 'bitbyte.MyJFrame'
$JAR_DIR = 'build\libs'
$ICON = 'process-icon1.ico'
$DEST = 'out\win'

New-Item -ItemType Directory -Force -Path $DEST | Out-Null

& jpackage `
  --type exe `
  --name $APP_NAME `
  --app-version $VERSION `
  --input $JAR_DIR `
  --main-jar "$APP_NAME-$VERSION.jar" `
  --main-class $MAIN_CLASS `
  --dest $DEST `
  --icon $ICON

Write-Host "EXE created in $DEST"

