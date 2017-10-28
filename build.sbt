name := """lila-jmh-benchmarks"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
)

scalacOptions := Seq(
  "-optimise",
  "-Yinline-warnings")

enablePlugins(JmhPlugin)
