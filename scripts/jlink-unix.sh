#!/usr/bin/env bash
set -euo pipefail

# Build a portable JRE (macOS/Linux) for Launch4j/jpackage.
# Output: out/<os>/jre (auto-detected)
# Usage: JAVA_HOME=/Library/Java/JavaVirtualMachines/temurin-25.jdk/Contents/Home bash scripts/jlink-unix.sh

if [[ -z "${JAVA_HOME:-}" ]]; then
  echo "JAVA_HOME not set" >&2; exit 1
fi
JMODS="$JAVA_HOME/jmods"
[[ -d "$JMODS" ]] || { echo "jmods not found at $JMODS" >&2; exit 1; }

OS="$(uname -s | tr '[:upper:]' '[:lower:]')"
DEST="out/${OS}/jre"
mkdir -p "$DEST"

MODULES="java.base,java.datatransfer,java.desktop,java.logging,java.xml,java.prefs,java.naming,jdk.unsupported"

jlink \
  --module-path "$JMODS" \
  --add-modules "$MODULES" \
  --no-header-files \
  --no-man-pages \
  --strip-debug \
  --compress=2 \
  --output "$DEST"

echo "Portable JRE created at $DEST"

