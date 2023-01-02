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
    }
}
