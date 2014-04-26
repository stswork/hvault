name := "h-vault"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "org.postgresql" % "postgresql" % "9.2-1003-jdbc4",
  "joda-time" % "joda-time" % "2.0",
  "com.jolbox" % "bonecp" % "0.8.0.RELEASE"
)

val main = play.Project(appName, appVersion, appDependencies).settings(
  resolvers += "Sonatype OSS Snapshots Repository" at "http://oss.sonatype.org/content/groups/public",
  resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
)

play.Project.playJavaSettings
