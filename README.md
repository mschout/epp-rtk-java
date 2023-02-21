# Build Notes
- At this time JDK8 is still required due to CORBA dependencies.
- Use the `gradlew` wrapper to build the jar.
- `./gradldew publishToSonatype closeAndReleaseSonatypeStagingRepository` will publish the artifact under `build/repo`
