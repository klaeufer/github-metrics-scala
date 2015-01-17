name := "clickcounter-spray-scala"

version := "0.1"

scalaVersion := "2.10.4"

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.4.+" % Test,
  "co.actioniq.thirdparty.me.lessis" % "hubcat_2.10" % "0.2.0-f74173eb"
)

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-simple" % "1.7.+"
)