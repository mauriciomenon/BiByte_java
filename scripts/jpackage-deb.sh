#!/usr/bin/env bash
set -euo pipefail

# Debian/Ubuntu DEB packaging using jpackage.
# Usage: VERSION=2.0.2 bash scripts/jpackage-deb.sh

VERSION="${VERSION:-dev}"
APP_NAME="BiByte"
MAIN_CLASS="bitbyte.MyJFrame"
JAR_DIR="build/libs"
ICON="process-icon1.ico"
DEST="out/deb"

mkdir -p "${DEST}"

jpackage \
  --type deb \
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

echo "DEB created in ${DEST}"

