# Release Distribution Guide

## Overview

Release artifacts for BiByte are large (43+ MiB with embedded JRE) and are **not stored in this repository** for performance reasons.

## Building Release Artifacts

### Prerequisites
- Java 25 JDK
- Gradle 9.2.0+
- jpackage and jlink tools

### Build Steps

```bash
# Build the project
gradle clean build -x test

# Generate distribution packages
gradle jpackageUberJar              # Creates BiByte-2.1.0.jar
gradle jpackageMac                  # Creates macOS .app bundle and DMG
gradle jpackageWin                  # Creates Windows EXE and MSI
gradle jpackageLinux                # Creates Debian DEB
```

### Output Locations

- **JAR files**: `build/libs/BiByte-*.jar`
- **macOS**: `build/jpackage/BiByte-*.dmg` and `build/jpackage/BiByte.app/`
- **Windows**: `build/jpackage/BiByte-*.exe` and `build/jpackage/BiByte-*.msi`
- **Linux**: `build/jpackage/BiByte-*.deb`

## Distribution Strategy

### For GitHub Releases
1. Use GitHub's **Releases** feature to attach built artifacts
2. Do NOT commit distribution files to the repository
3. Upload artifacts via the GitHub UI or using `gh release upload`

### For Automated CI/CD
Use `.github/workflows/publish-release.yml` workflow to:
1. Build artifacts automatically on tag push
2. Create GitHub Release
3. Upload artifacts directly to release

## .gitignore Rationale

The `release/` directory and build artifacts are ignored because:
- **Large file overhead**: macOS bundle is 174 files, 43+ MiB
- **Slow clone/fetch**: Unnecessary for development
- **Git push timeouts**: HTTP 408 errors on large pushes
- **Duplication**: Built locally on each machine as needed

## Manual Release Publishing

To publish a release manually:

```bash
# 1. Build locally
gradle clean build -x test
gradle jpackageUberJar

# 2. Create GitHub release (using gh CLI)
gh release create v2.1.0 build/libs/BiByte-2.1.0.jar \
  --title "Version 2.1.0" \
  --notes "Release notes here"

# 3. Or upload to existing release
gh release upload v2.1.0 build/libs/BiByte-2.1.0.jar
```

## Automating with GitHub Actions

The repository includes a reusable workflow that:
1. Builds all distribution packages
2. Creates/updates GitHub Release
3. Uploads artifacts automatically

Trigger by pushing a tag: `git tag v2.1.0 && git push origin v2.1.0`
