buildscript {
    dependencies {
        classpath("com.example.library:gradle-plugin:1.0.0-SNAPSHOT")
    }
}

plugins {
    application
}

apply(plugin = "library.gradle.plugin")
