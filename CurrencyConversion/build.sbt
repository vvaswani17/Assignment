

name := "CurrencyConversion"

version := "0.1"

scalaVersion := "2.13.6"

resolvers ++= Seq(
  "local ivy Repository" at "file://" + Path.userHome.absolutePath + "/.ivy2/local"
)
routesGenerator := InjectedRoutesGenerator

lazy val `cc` = (project in file(".")).enablePlugins(LagomScala).settings(lagomServiceHttpPort := 11111)
  .disablePlugins(LagomLogback)
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslApi,
      "com.softwaremill.macwire" %% "macros" % "2.3.3" % "provided",
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.13.0",
      "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.13.0",
      jdbc))

lagomKafkaEnabled in ThisBuild := false
lagomCassandraEnabled in ThisBuild := false
javaOptions in Universal ++= Seq(
  "-Dpidfile.path=/dev/null"
)

