package com.heygongc.build_logic

import org.gradle.api.JavaVersion

object ConfigData {
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0.0"
    const val COMPILE_SDK_VERSION = 34
    const val TARGET_SDK_VERSION = 34
    const val MIN_SDK_VERSION = 24
    val JAVA_VERSION = JavaVersion.VERSION_17
    const val JVM_TARGET = "17"
}