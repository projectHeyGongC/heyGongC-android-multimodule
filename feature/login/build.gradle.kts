plugins {
    id("heygongc.convention.android.composeModule")
    id("heygongc.convention.android.hilt")
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.heygongc.feature.login"

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // compose
    implementation(libs.bundles.compose)
    implementation(platform(libs.composeBom))
    implementation(libs.androidx.media3.common)
    debugImplementation(libs.composeUiTooling)

    // hilt
    implementation(libs.hilt)
    ksp(libs.hiltCompiler)
}