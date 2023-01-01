import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class LoggingPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.dependencies {

            "implementation"("org.apache.logging.log4j:log4j-api:2.17.2")
        }
    }
}