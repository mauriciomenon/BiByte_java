BiByte – Checklist de Publicação Manual

1) Gere os artefatos locais
- Jar: `gradle build` (gera `build/libs/BiByte-<versao>.jar`)
- Windows:
  - Auto‑contido: `gradle packageWinExe` ou `gradle packageWinMsi` (gera `out/win/*`)
  - Slim (com JRE portátil): `gradle packageWinSlimAll` (gera `out/win/*.exe` + `out/win/jre/`)
- macOS: `gradle packageMacDmg` (gera `out/mac/*.dmg`)
- Debian: `gradle packageDeb` (gera `out/deb/*.deb`)

2) Colete para upload
- `gradle prepareRelease -PreleaseVersion=<versao>` → agrupa itens em `release/<versao>/` e cria `BiByte-latest.jar`

3) Crie o Release no GitHub (UI)
- Título: `BiByte <versao>`
- Anexe arquivos de `release/<versao>/`
- Use `RELEASE-NOTES-TEMPLATE.md` como base para notas

