rootProject.name = "composite-build"

includeBuild("library") {
    dependencySubstitution {
        substitute(module("com.example.library:gradle-plugin")).with(project(":gradle-plugin"))
    }
}

includeBuild("application")
