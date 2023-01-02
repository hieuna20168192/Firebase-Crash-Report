package com.example.shared_plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

class GreetingPlugin implements Plugin<Project> {
    void apply(Project target) {
        target.task("greet") {
            it.doLast {
                print("Greet world!")
            }
        }

        // config androidXTest
        // Configuration.extendsFrom(org.gradle.api.artifacts.Configuration[])
        target.configurations {
            androidXTestImplementation.extendsFrom(testImplementation)
        }

        target.dependencies {
            testImplementation 'androidx.test.ext:junit:1.1.2'
            androidXTestImplementation "androidx.test.ext:junit-ktx:1.1.2"
            androidXTestImplementation "androidx.test:core-ktx:1.3.0"
            testImplementation "org.robolectric:robolectric:4.5.1"
        }
    }
}
