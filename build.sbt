name := "clickcounter-spray-scala"

version := "0.1"

scalaVersion := "2.11.4"

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.4.+" % Test,
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.+" % Test
)

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-simple" % "1.7.+"
)
