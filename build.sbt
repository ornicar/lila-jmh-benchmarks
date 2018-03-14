name := """lila-jmh-benchmarks"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
)

scalacOptions := Seq(
  "-optimise")

lazy val compression = RootProject(uri("git://github.com/lichess-org/compression.git"))
/* lazy val compression = RootProject(uri("git://github.com/lichess-org/compression.git#move-buffer")) */

dependsOn(compression)

enablePlugins(JmhPlugin)
