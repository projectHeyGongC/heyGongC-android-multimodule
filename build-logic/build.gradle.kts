plugins {
    `kotlin-dsl`
}

group = "com.heygongc.convention.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "heygongc.convention.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "heygongc.convention.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidDomain") {
            id = "heygongc.convention.android.domain"
            implementationClass = "AndroidDomainConventionPlugin"
        }
        register("androidHilt") {
            id = "heygongc.convention.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }

        register("androidComposeModule") {
            id = "heygongc.convention.android.composeModule"
            implementationClass = "AndroidComposeModuleConventionPlugin"
        }
    }
}