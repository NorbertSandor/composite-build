package com.example.library.gradle.plugin;

import org.gradle.api.GradleException;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.SourceSetContainer;

import java.io.*;
import java.nio.file.Files;

public class ExamplePlugin implements Plugin<Project> {
    @Override
    public void apply(Project target) {
        File generatedSources = new File(target.getBuildDir(), "generated-sources/java");

        SourceSetContainer sourceSets = (SourceSetContainer) target.getProperties().get("sourceSets");
        sourceSets.getByName("main").getAllJava().srcDir(generatedSources);

        File sourceLocation = new File(generatedSources, "com/example/generated");

        try {
            Files.createDirectories(sourceLocation.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Failed to create directory: " + sourceLocation, e);
        }

        File generatedClass = new File(sourceLocation, "GeneratedClass.java");
        try (OutputStream outputStream = new FileOutputStream(generatedClass); OutputStreamWriter writer = new OutputStreamWriter(outputStream)) {
            writer.write("package com.example.generated;\n");
            writer.write("\n");
            writer.write("public final class GeneratedClass {\n");
            writer.write("    public static final String Message = \"Hello World!\";\n");
            writer.write("}\n");
        } catch (Exception e) {
            throw new RuntimeException("Code generation failed.", e);
        }
    }
}
