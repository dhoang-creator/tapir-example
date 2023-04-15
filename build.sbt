val tapirVersion = "1.2.10"

lazy val rootProject = (project in file(".")).settings(
  Seq(
    name := "tapir-example",
    version := "0.1.0-SNAPSHOT",
    organization := "com.dhoang-creator",
    scalaVersion := "2.13.10",
    libraryDependencies ++= Seq(
      "com.softwaremill.sttp.tapir" %% "tapir-http4s-server-zio" % tapirVersion,
      "com.softwaremill.sttp.tapir" %% "tapir-http4s-server" % tapirVersion,
      "org.http4s" %% "http4s-ember-server" % "0.23.18",
      "com.softwaremill.sttp.tapir" %% "tapir-json-circe" % tapirVersion,
      "ch.qos.logback" % "logback-classic" % "1.4.6",
      "com.softwaremill.sttp.tapir" %% "tapir-sttp-stub-server" % tapirVersion % Test,
      "dev.zio" %% "zio-test" % "2.0.5" % Test,
      "dev.zio" %% "zio-test-sbt" % "2.0.5" % Test,
      "com.softwaremill.sttp.client3" %% "circe" % "3.8.13" % Test
    ),
    testFrameworks := Seq(new TestFramework("zio.test.sbt.ZTestFramework"))
  )
)
