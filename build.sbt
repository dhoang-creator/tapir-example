name := "tapir-example"
organization := "com.dhoang-creator"
version := "0.1.0-SNAPSHOT"

scalaVersion := "2.13.10"
val tapirVersion = "1.4.0"

libraryDependencies ++= Seq(
  // Akka
  "com.typesafe.akka"               %% "akka-actor"                 % "2.8.0",
  "com.typesafe.akka"               %% "akka-actor-typed"           % "2.8.0",
  "com.typesafe.akka"               %% "akka-stream"                % "2.8.0",
  "com.typesafe.akka"               %% "akka-stream"                % "2.8.0",
  "com.typesafe.akka"               %% "akka-http"                  % "10.5.0",

  // Akka Caching
  "com.typesafe.akka"               %% "akka-http-caching"          % "10.5.0",

  // tapir
  "com.softwaremill.sttp.tapir"     %% "tapir-akka-http-server"     % tapirVersion,
  "com.softwaremill.sttp.tapir"     %% "tapir-http4s-server-zio"    % tapirVersion,
  "com.softwaremill.sttp.tapir"     %% "tapir-http4s-server"        % tapirVersion,

  // http4s
  "org.http4s"                      %% "http4s-ember-server"        % "0.23.18",
  "com.softwaremill.sttp.tapir"     %% "tapir-json-circe"           % tapirVersion,

  // Postgres DB
  "org.postgresql"                  %% "postgresql"                 % "42.5.4",

  // Slick
  "com.typesafe.slick"              %% "slick"                      % "3.4.1",
  "com.typesafe.slick"              %% "slick-hickaricp"            % "3.4.1",
  "com.github.tminglei"             %% "slick-pg"                   % "0.21.1",
  "com.h2database"                  %% "h2"                         % "2.1.214",



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

