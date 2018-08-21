name := """lila-jmh-benchmarks"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-json" % "2.6.9",
  "org.scala-stm" %% "scala-stm" % "0.8"
)

scalacOptions := Seq(
  "-optimise")

lazy val compression = RootProject(uri("git://github.com/lichess-org/compression.git"))
/* lazy val compression = RootProject(uri("git://github.com/lichess-org/compression.git#move-buffer")) */

dependsOn(compression)

enablePlugins(JmhPlugin)
