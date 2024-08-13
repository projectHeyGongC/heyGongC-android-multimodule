import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.heygongc.build_logic.appConvention
import com.heygongc.build_logic.configureBuildTypes
import com.heygongc.build_logic.configureKotlin
import com.heygongc.build_logic.configureKotlinAndroid
import com.heygongc.build_logic.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidComposeModuleConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            dependencies {
                implementation(project(":domain"))
                implementation(project(":data"))
                implementation(project(":common-ui"))
            }

            extensions.configure<LibraryExtension> {
                appConvention()
                configureKotlinAndroid()
                configureBuildTypes()
                configureKotlin(project)
            }
        }
    }
}