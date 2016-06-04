import sbt.Keys._
import sbt._

lazy val root = (project in file("."))
  .enablePlugins(JavaAppPackaging)
  .settings(
    name := "akka-http-microservice",
    organization := "com.github.lavenderx",
    version := "1.0",

    homepage := Some(url("https://github.com/lavenderx/akka-http-microservice-seed")),

    developers := List(Developer(
      "lavenderx",
      "Zongzhi Bai",
      "dolphineor@gmail.com",
      url("https://github.com/lavenderx"))
    ),

    scmInfo := Some(ScmInfo(
      url("https://github.com/lavenderx/akka-http-microservice-seed"),
      "scm:git:git@github.com:lavenderx/akka-http-microservice-seed",
      Some("scm:git:git@github.com:lavenderx/akka-http-microservice-seed"))
    ),

    licenses := Seq(
      ("MIT", url("https://opensource.org/licenses/MIT"))
    ),

    scalaVersion := "2.11.8",

    scalacOptions := Seq(
      "-unchecked",
      "-encoding", "UTF-8"
    ),

    javacOptions ++= Seq(
      "-source", "1.8",
      "-target", "1.8",
      "-Xlint:unchecked"
    ),

    ivyScala := ivyScala.value map {
      _.copy(overrideScalaVersion = true)
    },

    resolvers := Seq(
      Resolver.mavenLocal,
      "gtan repox" at "http://repox.gtan.com:8078/",
      "maven repo" at "https://repo1.maven.org/maven2/",
      "typesafe repo" at "https://dl.bintray.com/typesafe/maven-releases/",
      "sbt-plugin repo" at "https://dl.bintray.com/sbt/sbt-plugin-releases/"
    ),

    libraryDependencies ++= {
      val akkaVersion = "2.4.6"
      val scalaTestVersion = "2.2.6"
      Seq(
        "com.typesafe.akka" %% "akka-actor" % akkaVersion,
        "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
        "com.typesafe.akka" %% "akka-stream" % akkaVersion,
        "com.typesafe.akka" %% "akka-http-experimental" % akkaVersion,
        "com.typesafe.akka" %% "akka-http-jackson-experimental" % akkaVersion,
        "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaVersion,
        "com.typesafe.akka" %% "akka-http-testkit" % akkaVersion,
        "org.scalatest" %% "scalatest" % scalaTestVersion % "test"
      )
    }
  )
