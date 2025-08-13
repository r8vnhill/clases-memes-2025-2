// Este archivo build.sbt configura un proyecto Scala usando SBT (Scala Build Tool).
// Define información general del proyecto, opciones del compilador, dependencias y la estructura de subproyectos.
// En este caso, se prepara un entorno común para varias clases del curso (CC3002), facilitando la reutilización de
// configuración.

// Define la versión de Scala que se usará en el proyecto
val scala3Version = "3.7.2"

// Establece la organización del proyecto (usado en nombres de paquetes y publicación)
ThisBuild / organization := "cl.uchile.dcc"

// Nombre del proyecto raíz
ThisBuild / name := "cc3002-clases-2025-2"

// Configuraciones comunes para todos los subproyectos
lazy val commonSettings = Seq(
    // Opciones para el compilador Scala
    scalacOptions ++= Seq(
        "-deprecation", // Muestra advertencias si se usan APIs obsoletas
        "-unchecked",   // Muestra advertencias por tipos no verificados
        "-feature"      // Muestra advertencias cuando se usan características avanzadas del lenguaje
    ),

    // Define la versión de Scala a usar
    scalaVersion := scala3Version,

    // Agrega MUnit como framework de testing, solo para el entorno de pruebas
    libraryDependencies += "org.scalameta" %% "munit" % "1.1.1" % Test
)

// Subproyecto correspondiente a la clase 01: tipado estático
lazy val staticTyping = project
    .in(file("01-static-typing")) // Ubicación del subproyecto
    .settings(commonSettings *)   // Aplica las configuraciones comunes

// Subproyecto correspondiente a la clase 02: introducción a OOP
lazy val introOOP = project
    .in(file("02-intro-oop")) // Ubicación del subproyecto
    .settings(commonSettings *) // Aplica las configuraciones comunes

// Subproyecto correspondiente a la clase 03: testing
lazy val testing = project
    .in(file("03-testing")) // Ubicación del subproyecto
    .settings(commonSettings *) // Aplica las configuraciones comunes
    .settings(
      libraryDependencies += "org.junit.jupiter" % "junit-jupiter-api" % "6.0.0-M2" % Test
    )

// Proyecto raíz que agrega el subproyecto "staticTyping"
lazy val root = project
    .in(file(".")) // Directorio raíz del proyecto
    .aggregate(staticTyping, introOOP) // Agrega los subproyectos
    .settings(commonSettings *) // También aplica las configuraciones comunes
