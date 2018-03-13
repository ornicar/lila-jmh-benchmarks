name := """lila-jmh-benchmarks"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
)

scalacOptions := Seq(
  "-optimise",
  "-Yinline-warnings")

lazy val compression = RootProject(uri("git://github.com/lichess-org/compression.git"))
/* lazy val compression = RootProject(uri("git://github.com/lichess-org/compression.git#move-buffer")) */

dependsOn(compression)

enablePlugins(JmhPlugin)
