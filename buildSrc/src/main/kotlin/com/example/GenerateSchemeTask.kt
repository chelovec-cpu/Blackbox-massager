package com.example

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

abstract class GenerateSchemeTask : DefaultTask() {
    @TaskAction
    fun generate() {
        println("Scheme generation skipped - using custom server")
    }
}
