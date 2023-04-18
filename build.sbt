name := "tapir-example"
organization := "com.dhoang-creator"
version := "0.1.0-SNAPSHOT"



lazy val rootProject = (project in file(".")).enablePlugins(OpenapiCodegenPlugin)

scalaVersion := "2.13.10"
val tapirVersion = "1.2.10"

libraryDependencies ++= Seq(
  // Akka
  "com.typesafe.akka"               %% "akka-actor"                 % "2.8.0",
  "com.typesafe.akka"               %% "akka-actor-typed"           % "2.8.0",
  "com.typesafe.akka"               %% "akka-stream"                % "2.8.0",
  "com.typesafe.akka"               %% "akka-stream"                % "2.8.0",
  "com.typesafe.akka"               %% "akka-http"                  % "10.5.0",

  // tapir
  "com.softwaremill.sttp.tapir"     %% "tapir-akka-http-server"     % tapirVersion,
  "com.softwaremill.sttp.tapir"     %% "tapir-http4s-server-zio"    % tapirVersion,
  "com.softwaremill.sttp.tapir"     %% "tapir-http4s-server"        % tapirVersion,

  // http4s
  "org.http4s"                      %% "http4s-ember-server"        % "0.23.18",
  "com.softwaremill.sttp.tapir"     %% "tapir-json-circe"           % tapirVersion,

  // slf4j alt
  "ch.qos.logback"                  % "logback-classic"             % "1.4.6",

  // Test frameworks
  "com.softwaremill.sttp.tapir"     %% "tapir-sttp-stub-server"     % tapirVersion  % Test,
  "dev.zio"                         %% "zio-test"                   % "2.0.10"      % Test,
  "dev.zio"                         %% "zio-test-sbt"               % "2.0.10"      % Test,
  "com.softwaremill.sttp.client3"   %% "circe"                      % "3.8.13"      % Test,
  "org.scalactic"                   %% "scalactic"                  % "3.2.15"      % Test,
  "org.scalatest"                   %% "scalatest"                  % "3.2.15"      % Test,
  "com.typesafe.akka"               %% "akka-stream-testkit"        % "2.8.0"       % Test
)

testFrameworks := Seq(new TestFramework("zio.test.sbt.ZTestFramework"))

