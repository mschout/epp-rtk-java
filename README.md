# Build Notes
- At this time JDK8 is still required due to CORBA dependencies.
- Use the `gradlew` wrapper to build the jar.
- `./gradldew publish` will publish the artifact under `build/repo` and you can
  just upload it to the UI on `https://maven.gkg.net/nexus/`  It's non-trivial
  to get this upload to happen via `./gradlew publish` due to the self signed
  ssl certificate.
