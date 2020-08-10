plugins {
    `java-gradle-plugin`
}

dependencies {
    project(":utils")
}

gradlePlugin {
    plugins {
        register("library-gradle-plugin") {
            id = "library.gradle.plugin"
            implementationClass = "com.example.library.gradle.plugin.ExamplePlugin"
        }
    }
}
