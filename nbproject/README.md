These files serve as templates for NetBeans compatibility. NetBeans typically regenerates `build-impl.xml` and `private/*.properties` on first open. If you want to use NetBeans, you can copy the templates to the expected locations or simply let NetBeans regenerate them.

Included templates:

- `build-impl.xml.template`: Placeholder for the generated Ant targets NetBeans uses internally.
- `private/private.properties.template`: Example of a private properties file (user/machine-specific), not required for command-line builds.

Command-line builds are recommended for day-to-day work:

- Gradle (recommended): `gradle build`, `gradle run`, `gradle test`
- Ant (legacy kept): `ant clean jar`

