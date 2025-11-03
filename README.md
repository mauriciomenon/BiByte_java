# BiByte Conversor

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

- v2.0.0 (Gradle Completo)
  - Build, testes e execução via Gradle; Ant removido.

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
