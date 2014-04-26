name := "h-vault"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "org.postgresql" % "postgresql" % "9.2-1003-jdbc4",
  "joda-time" % "joda-time" % "2.0"
)

play.Project.playJavaSettings