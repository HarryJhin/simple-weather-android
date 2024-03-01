pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "simple-weather-android"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
includes("core")
includes("view")

fun includes(directory: String) {
    file(directory).listFiles()?.forEach { file ->
        if (file.isDirectory) {
            include(":$directory:${file.name}")
        }
    }
}