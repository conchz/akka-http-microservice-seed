organization in ThisBuild := "com.github.lavenderx"
scalaVersion in ThisBuild := "2.11.8"

lazy val commonSettings = Seq(
  name := "akka-http-microservice",
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
    "scm:git:git@github.com:lavenderx/akka-http-microservice-seed.git")
  ),

  licenses := Seq(
    ("MIT", url("https://opensource.org/licenses/MIT"))
  ),

  fork in run := true,

  scalacOptions ++= Seq(
    "-encoding", "UTF-8",
    "-unchecked",
    "-deprecation"
  ),

  javacOptions in compile ++= Seq(
    "-encoding", "UTF-8",
    "-source", "1.8",
    "-target", "1.8",
    "-Xlint:unchecked",
    "-Xlint:deprecation"
  ),

  ivyScala := ivyScala.value map {
    _.copy(overrideScalaVersion = true)
  },

  resolvers ++= Seq(
    "repox" at "http://repox.gtan.com:8078/",
    "hseeberger" at "https://dl.bintray.com/hseeberger/maven/"
  ),

  libraryDependencies ++= {
    val akkaVersion = "2.4.8"
    val akkaHttpJson4sVersion = "1.7.0"
    val scalaTestVersion = "2.2.6"
    Seq(
      "com.typesafe.akka" %% "akka-actor" % akkaVersion,
      "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
      "com.typesafe.akka" %% "akka-stream" % akkaVersion,
      "com.typesafe.akka" %% "akka-http-experimental" % akkaVersion,
      "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaVersion,
      "de.heikoseeberger" %% "akka-http-json4s" % akkaHttpJson4sVersion,
      "ch.qos.logback" % "logback-classic" % "1.1.7",
      "com.typesafe.akka" %% "akka-http-testkit" % akkaVersion % Test,
      "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % Test,
      "org.scalatest" %% "scalatest" % scalaTestVersion % Test
    )
  },

  unmanagedSourceDirectories in Compile := Seq((scalaSource in Compile).value),
  unmanagedSourceDirectories in Test := Seq((scalaSource in Test).value)
)

lazy val root = (project in file("."))
  .enablePlugins(JavaAppPackaging)
  .settings(commonSettings: _*)
