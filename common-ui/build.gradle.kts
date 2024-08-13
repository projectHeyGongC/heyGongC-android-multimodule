plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    id("heygongc.convention.android.library")
}

android {
    namespace = "com.example.common_ui"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // compose
    implementation(libs.bundles.compose)
    implementation(platform(libs.composeBom))
    debugImplementation(libs.composeUiTooling)
}