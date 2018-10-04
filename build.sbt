import Dependencies._
import microsites._

enablePlugins(MicrositesPlugin)

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.hdzco",
      scalaVersion := "2.12.7",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "quantum-computing",
    micrositeName := "Quantum Computing",
    micrositeDescription      := "Quantum Computing for Mortals",
    micrositeBaseUrl          := "/quantum-computing",
    micrositeDocumentationUrl := "/quantum-computing/docs",
    micrositeAuthor           := "Daniel Hernández Mota | Rodrigo Hernández Mota" ,
    micrositeHomepage         := "https://rhdzmota.github.io/quantum-computing/",
    micrositeGithubOwner      := "rhdzmota",
    micrositeGithubRepo       := "quantum-computing",
    micrositeGitterChannel    := false,
    micrositeHighlightLanguages ++= Seq("haskell", "fsharp", "scala", "python"),
    micrositeCDNDirectives    := CdnDirectives(
      jsList = List(
        "https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.5/MathJax.js?config=TeX-MML-AM_CHTML,https://oscarvarto.github.io/learning-scala/js/mathjax-config.js"
      )
    ),
    libraryDependencies += scalaTest % Test
  )
