name := "wartremover-example-println"

organization := "org.brianmckenna"

scalaVersion := "2.10.3"

libraryDependencies += "org.brianmckenna" %% "wartremover" % "0.8-SNAPSHOT"

addCompilerPlugin("org.brianmckenna" %% "wartremover" % "0.8-SNAPSHOT")

scalacOptions in Test <++= packageBin in Compile map { wartJar => Seq(
  "-P:wartremover:cp:" + wartJar.toURI.toURL,
  "-P:wartremover:traverser:org.brianmckenna.nescala.warts.Println"
) }
