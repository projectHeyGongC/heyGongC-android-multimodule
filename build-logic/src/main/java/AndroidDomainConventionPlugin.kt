import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidDomainConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.jvm")
                apply("com.google.devtools.ksp")
            }

//            dependencies {
//                implementation(project(":core-ui"))
//                implementation(project(":features-navigator"))
//            }
        }
    }
}