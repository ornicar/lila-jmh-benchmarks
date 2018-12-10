name := """lila-jmh-benchmarks"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-json" % "2.6.9",
  "com.typesafe.akka" %% "akka-actor" % "2.4.20",
  "org.scala-stm" %% "scala-stm" % "0.8"
)

scalacOptions := Seq(
  "-optimise")

lazy val compression = RootProject(uri("git://github.com/lichess-org/compression.git"))
/* lazy val compression = RootProject(uri("git://github.com/lichess-org/compression.git#move-buffer")) */

dependsOn(compression)

enablePlugins(JmhPlugin)
