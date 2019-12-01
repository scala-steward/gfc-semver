name := "gfc-semver"

organization := "com.gilt"

scalaVersion := "2.12.10"

crossScalaVersions := Seq(scalaVersion.value, "2.13.1")

scalacOptions += "-target:jvm-1.8"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.1.0" % Test
)

releaseCrossBuild := true

releasePublishArtifactsAction := PgpKeys.publishSigned.value

publishMavenStyle := true

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

homepage := Some(url("https://github.com/gfc-collective/gfc-semver"))

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <scm>
    <url>https://github.com/gfc-collective/gfc-semver.git</url>
    <connection>scm:git:git@github.com:gfc-collective/gfc-semver.git</connection>
  </scm>
  <developers>
    <developer>
      <id>stjohnb</id>
      <name>Brendan St John</name>
      <url>https://github.com/stjohnb</url>
    </developer>
  </developers>
)
