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
      "repox" at "http://repox.gtan.com:8078/",
      "hseeberger" at "https://dl.bintray.com/hseeberger/maven/"
    ),

    libraryDependencies ++= {
      val akkaVersion = "2.4.7"
      val akkaHttpJson4sVersion = "1.6.0"
      val scalaTestVersion = "2.2.6"
      Seq(
        "com.typesafe.akka" %% "akka-actor" % akkaVersion,
        "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
        "com.typesafe.akka" %% "akka-stream" % akkaVersion,
        "com.typesafe.akka" %% "akka-http-experimental" % akkaVersion,
        "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaVersion,
        "de.heikoseeberger" %% "akka-http-json4s" % akkaHttpJson4sVersion,
        "com.typesafe.akka" %% "akka-http-testkit" % akkaVersion,
        "org.scalatest" %% "scalatest" % scalaTestVersion % "test"
      )
    }
  )
