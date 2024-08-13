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

rootProject.name = "HeyGongC"
include(
    ":app",
    ":domain",
    ":feature",
    ":feature:login",
    ":feature:main-monitoring",
    ":feature:main-analysis",
    ":feature:main-profile",
    ":common-ui"
)
include(":data")
