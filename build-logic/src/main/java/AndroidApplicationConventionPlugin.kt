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

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            dependencies {
                implementation(project(":domain"))
                implementation(project(":data"))
                implementation(project(":feature:login"))
                implementation(project(":feature:main-analysis"))
                implementation(project(":feature:main-monitoring"))
                implementation(project(":feature:main-profile"))
                implementation(project(":common-ui"))
            }

            extensions.configure<BaseAppModuleExtension> {
                appConvention()
                configureKotlinAndroid()
                configureBuildTypes()
                configureKotlin(project)
            }
        }
    }
}