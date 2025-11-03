# BiByte Conversor

Quickstart
- Gradle: `gradle build && gradle run`
- Ant: `ant clean jar && java -jar dist/Bitbyte.jar`
- Download direto: última versão pronta (JAR)
  - `https://github.com/mauriciomenon/BiByte_java/releases/latest/download/BiByte-latest.jar`

BiByte é uma ferramenta desktop em Java para engenheiros de automação e controle que trabalham com sistemas SCADA (IEC-870-5). A aplicação converte valores entre os formatos "BitByte" e "PTNO" e oferece tabelas de consulta rápida (UTRs e códigos de cores de cabos).

## Histórico de Versões

- v1.0.0 (Legado, Ant/JDK 7)
  - Estado: versão original do projeto (NetBeans + Ant + Swing + Launch4j).
  - Ferramentas: Ant, JDK 7.
  - Build: `ant jar`.
  - README (v1.0.0):
    - Java 1.7; Ant; NetBeans; UI Swing; empacotamento via Launch4j; estrutura `src/`, `test/`, `dist/`, `nbproject/`.

- v1.1.0 (Refactor + Tests, Ant/JDK 7)
  - Merge do PR de melhoria de qualidade (google-jules):
    - UI (`MyJFrame.java`): nomes de campos claros (`t1/t2/t3/t4` → `bitByteInput/ptnoInput/ptnoOutput/bitByteOutput`), remoção de boilerplate do Form Editor, lambdas no `EventQueue`, tratamento de exceções simplificado.
    - Listener: `MeuListener` atualizado para aceitar campos renomeados e um `errorLabel` na UI.
    - Lógica (`Calculos.java`): redução/remoção de `JOptionPane` em favor de funções puras e constantes para regras de conversão.
    - Testes: adição de `test/operacoes/CalculosTest.java` (JUnit 4) cobrindo conversões e casos inválidos.
  - Ferramentas: Ant, JDK 7.
  - Build: `ant jar`.

- v1.8.0 (Marco de Modernização)
  - Consolidação do plano de modernização e documentação.

- v1.9.0 (Ant + Java 17)
  - Atualização de `javac.source`/`javac.target` para 17 nos projetos Ant (`nbproject/` e `Bitbyte/nbproject/`).
  - Build (Ant) sob JDK 17: `ant clean jar`.

- v1.9.1 (Gradle inicial)
  - Introdução do Gradle (Java 17), estrutura de fontes `src/` e `test/`, e JUnit 5.

- v1.9.2 (Compatibilidade local JDK)
  - Ajustes no Gradle para compilar com JDK atual sem toolchain.

- v1.9.3 (Ant/Gradle em Java 25)
  - Projetos Ant migrados para `javac.source/target=25`.
  - Gradle configurado com toolchain Java 25 e JUnit 5 atualizado.

- v1.9.1+ (Migração Gradual para Gradle)
  - Introdução de Gradle (Java 17), ajustes de estrutura e testes (JUnit 5), documentação atualizada.

- v2.0.0 (Gradle como principal)
  - Build, testes e execução via Gradle.
  - Ant/NetBeans (legado) mantidos no repositório para compatibilidade e referência histórica.

## Como Compilar e Executar

Enquanto Ant for o sistema principal (até 1.9.3):
- Requisitos: JDK 25 (ou superior) + Ant.
- Comando: `ant clean jar`.
- Saída: `dist/Bitbyte.jar`.

Após migração para Gradle (1.9.1+ até 2.0.0):
- Requisitos: JDK 25 e Gradle.
- Compilar: `gradle build` (JAR em `build/libs/`).
- Executar: `gradle run` ou `java -jar build/libs/BiByte-<versao>.jar`.
- Testes: `gradle test`.

## Plano de Modernização (XP)

1. Unificação de estrutura e documentação (v1.8.0).
2. Atualizar Ant para Java 17 e validar build (v1.9.0).
3. Introduzir Gradle (Java 17), JUnit 5 e testes (v1.9.1+).
4. Migrar totalmente para Gradle e remover Ant (v2.0.0).

## Releases e Artefatos

- Este repositório usa GitHub Actions para anexar JARs compilados automaticamente aos Releases.
- Como funciona:
  - Ao publicar um Release (menu Releases do GitHub) para um tag específico, a ação compila e anexa o JAR.
  - Tags suportados:
    - v1.0.x e v1.1.x: build via Ant em Java 8 (gera `dist/Bitbyte.jar`).
    - v1.8.x e v1.9.0: build via Ant em Java 17 (gera `dist/Bitbyte.jar`).
    - v1.9.1+ e v2.x: build via Gradle em Java 25 (gera `build/libs/*.jar`).
- Para Releases anteriores (ex.: v1.0.0 e v1.1.0):
  1. Crie um Release para cada tag (v1.0.0, v1.1.0) pelo GitHub.
  2. A action irá compilar e anexar o JAR automaticamente.

## Resumo das Tags

- v1.0.0, v1.1.0 (legado Ant/JDK7)
- v1.8.0, v1.9.0, v1.9.1, v1.9.2, v1.9.3
- v2.0.0, v2.0.1, v2.0.2

As tags disparam o workflow e geram releases com JAR anexado conforme a estratégia do tag.

Notas de release:
- Curadas para v1.0.0 e v1.1.0 (com o conteúdo definido para essas versões).
- Genéricas e consistentes para as demais versões.

## CI (GitHub Actions)

- Workflow: `.github/workflows/release-build.yml`
- Dispara em:
  - `release` (published)
  - push de tags `v*`
- Estratégia por tag:
  - v1.0.x e v1.1.x → Ant + Java 8 → `dist/Bitbyte.jar`
  - v1.8.x e v1.9.0 → Ant + Java 17 → `dist/Bitbyte.jar`
  - v1.9.1+ e v2.x → Gradle + Java 25 → `build/libs/*.jar`
- Para Gradle, a versão do JAR é ajustada com o próprio tag via `-PprojVersion=<tag>`.
- Publica/atualiza release e anexa artefatos automaticamente.

## Builds Locais

- Ant (Java 25): validado
  - `ant clean jar` → sucesso (gera `dist/Bitbyte.jar`).
- Gradle (Java 25):
  - `gradle build`, `gradle test`, `gradle run`
  - Em ambientes restritos (como contêineres sem nativo), o Gradle pode falhar por `libnative-platform`; no ambiente local/CI roda normalmente.

## Guia Rápido: Versões x Builds (sem confusão)

- v1.0.x e v1.1.x
  - Ferramenta: Ant (NetBeans opcional)
  - Java: 7 (histórico) | compatível local com 25 usando Ant simples
  - NetBeans: NÃO é obrigatório (apenas se quiser abrir o projeto nele)
  - Comando (direto): `ant jar` → `dist/Bitbyte.jar`
  - Observação: arquivos `nbproject/` existem para compatibilidade; build direto via Ant é preferível.

- v1.8.x e v1.9.0
  - Ferramenta: Ant (NetBeans opcional)
  - Java: 17 (no histórico), hoje compila em 25
  - NetBeans: NÃO é obrigatório
  - Comando (direto): `ant clean jar` → `dist/Bitbyte.jar`

- v1.9.1, v1.9.2, v1.9.3
  - Ferramenta: Gradle (principal) | Ant ainda disponível
  - Java: 25
  - NetBeans: NÃO é obrigatório
  - Comandos (direto):
    - Gradle: `gradle build` | `gradle run` | `gradle test`
    - Ant: `ant clean jar`

- v2.0.x (principal atual)
  - Ferramenta: Gradle (recomendado) | Ant legado mantido
  - Java: 25
  - NetBeans: NÃO é obrigatório (encorajado build direto via Gradle/Ant)
  - Comandos (direto):
    - Gradle: `gradle build` | `gradle run` | `gradle test`
    - Ant: `ant clean jar`

Notas importantes:
- NetBeans é opcional e mantido por compatibilidade/histórico; a forma direta (linha de comando) é recomendada.
- O mesmo JAR roda em macOS/Linux/Windows com uma JVM compatível.
- Empacotamento nativo via `jpackage` está documentado na seção “Guia Completo de Uso e Build Local”.

## Guia Completo de Uso e Build Local (macOS, Debian/Ubuntu, Windows)

- Pré‑requisitos gerais
  - JDK 25 (Temurin, Zulu ou Oracle). Verifique com: `java -version`.
  - Gradle 8/9 (opcional; você pode usar apenas o JDK + `javac/jar`).

- macOS (arm64 Apple Silicon e x64 Intel)
  - Instalar JDK: `brew install --cask temurin` (ou Temurin 25 específico se necessário)
  - Instalar Gradle: `brew install gradle`
  - Compilar: `gradle clean build`
  - Executar: `gradle run` ou `java -jar build/libs/BiByte-<versao>.jar`
  - Empacotar (opcional, nativo) via `jpackage` (requer JDK com `jpackage`):
    - `jpackage --type dmg --name BiByte --app-version <versao> --input build/libs --main-jar BiByte-<versao>.jar --main-class bitbyte.MyJFrame --dest out/mac --icon process-icon1.ico`
  - Observação: o JAR é multiplataforma e roda tanto em arm64 quanto em x64 desde que haja JVM compatível instalada.

- Debian/Ubuntu (amd64 e arm64)
  - Instalar JDK: `sudo apt-get update && sudo apt-get install -y temurin-25-jdk` (ou openjdk-25-jdk quando disponível)
  - Instalar Gradle (opcional): `sudo apt-get install -y gradle` (ou via SDKMAN)
  - Compilar: `gradle clean build`
  - Executar: `gradle run` ou `java -jar build/libs/BiByte-<versao>.jar`
  - Empacotar (opcional) via `jpackage`:
    - `.deb`: `jpackage --type deb --name bibyte --app-version <versao> --input build/libs --main-jar BiByte-<versao>.jar --main-class bitbyte.MyJFrame --dest out/deb --icon process-icon1.ico`
    - `.rpm`: `jpackage --type rpm ...` (em distros RPM)
  - Observação: use um JDK da mesma arquitetura (amd64 ou arm64) do sistema ao empacotar.

- Windows (amd64 e arm64)
  - Instalar JDK: via winget/Chocolatey ou installer Temurin para Windows
  - Instalar Gradle (opcional): `choco install gradle` ou usar apenas o JDK
  - Compilar: `gradle clean build`
  - Executar: `gradle run` ou `java -jar build\libs\BiByte-<versao>.jar`
  - Empacotar (opcional):
    - `jpackage --type msi --name BiByte --app-version <versao> --input build\libs --main-jar BiByte-<versao>.jar --main-class bitbyte.MyJFrame --dest out\win --icon process-icon1.ico`
    - Alternativa (legado): Launch4j com `bitbyte_Launch4j.xml` (hoje preferimos `jpackage`).

### Observações sobre Arquitetura (arm64 vs amd64)
- O JAR (bytecode Java) é multiplataforma. O mesmo artefato roda em qualquer SO/arquitetura com JVM compatível.
- Para empacotamento nativo (`jpackage`), use um JDK da mesma arquitetura do sistema alvo (ex.: empacotar `msi` arm64 no Windows arm64).
- Cross‑empacotamento completo não é suportado pelo `jpackage` (ex.: gerar `.msi` no Linux). Se necessário, utilize VMs/containers da plataforma alvo (QEMU/UTM/VMware) e execute os comandos locais lá.

### Build 100% Offline
- Primeiro build pode baixar dependências (JUnit). Após cache local, use `gradle --offline build`.
- Alternativa sem Gradle (apenas JDK):
  - Compilar: `javac -d out $(find src -name "*.java")`
  - Empacotar JAR com Manifest (Main-Class setada em Gradle; para manual, crie `MANIFEST.MF` com `Main-Class: bitbyte.MyJFrame`):
    - `jar cfm BiByte-manual.jar MANIFEST.MF -C out .`

## Detalhes Retroativos (v1.0.0 e v1.1.0)

- v1.0.0 (Ant/JDK7)
  - Build: `ant jar` → `dist/Bitbyte.jar`
  - Empacotamento Windows: Launch4j (`bitbyte_Launch4j.xml`).
  - Estrutura: `src/`, `test/`, `dist/`, `nbproject/`.

- v1.1.0 (Refactor + Tests, Ant/JDK7)
  - Mudanças funcionais: refinos na UI, lógica de conversão mais pura, primeiros testes unitários.
  - Build: `ant jar`.
  - Execução: `java -jar dist/Bitbyte.jar`.
