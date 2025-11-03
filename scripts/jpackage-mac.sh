#!/usr/bin/env bash
set -euo pipefail

# macOS DMG packaging using jpackage.
# Usage: VERSION=2.0.2 bash scripts/jpackage-mac.sh

VERSION="${VERSION:-dev}"
APP_NAME="BiByte"
MAIN_CLASS="bitbyte.MyJFrame"
JAR_DIR="build/libs"
ICON="process-icon1.ico"
DEST="out/mac"

mkdir -p "${DEST}"

jpackage \
  --type dmg \
  --name "${APP_NAME}" \
  --app-version "${VERSION}" \
  --input "${JAR_DIR}" \
  --main-jar "${APP_NAME}-${VERSION}.jar" \
  --main-class "${MAIN_CLASS}" \
  --dest "${DEST}" \
  --icon "${ICON}" || {
    echo "If main JAR name differs, pass MAIN_JAR explicitly or set VERSION accordingly." >&2
    exit 1
  }

echo "DMG created in ${DEST}"

