@file:Suppress("UnstableApiUsage")

package com.heygongc.build_logic

import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.BaseExtension
import com.heygongc.build_logic.ConfigData.COMPILE_SDK_VERSION
import com.heygongc.build_logic.ConfigData.MIN_SDK_VERSION
import com.heygongc.build_logic.ConfigData.TARGET_SDK_VERSION
import com.heygongc.build_logic.ConfigData.VERSION_CODE
import com.heygongc.build_logic.ConfigData.VERSION_NAME
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * Configure base Kotlin with Android options
 */
fun BaseExtension.configureKotlinAndroid() {
    compileSdkVersion(COMPILE_SDK_VERSION)

    defaultConfig {
        targetSdk = TARGET_SDK_VERSION
        minSdk = MIN_SDK_VERSION
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

fun BaseExtension.appConvention() {
    namespace = "com.heygongc"
    defaultConfig {
        versionCode = VERSION_CODE
        versionName = VERSION_NAME
        vectorDrawables.useSupportLibrary = true
    }
}

fun <T : BuildType> CommonExtension<*, T, *, *, *, *>.configureBuildTypes() {
    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        debug {
            isJniDebuggable = true
        }
    }
}

fun configureKotlin(project: Project) {
    project.tasks.withType(KotlinCompile::class.java).configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }
}
