pluginManagement {
    includeBuild("toolkit/build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://www.jitpack.io") }
    }
}

rootProject.name = "Smart Energy"
include(":app")
include(":commons")
//include(":features:onboarding")
include(":toolkit:core")
//include(":toolkit:auth")
//include(":toolkit:repository:firebase")
//include(":toolkit:repository:iot")
