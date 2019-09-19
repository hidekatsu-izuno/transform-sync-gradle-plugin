/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package net.arnx.fileconv.gradle;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.io.FileWriter;
import java.nio.file.Files;
import org.gradle.testkit.runner.GradleRunner;
import org.gradle.testkit.runner.BuildResult;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A simple functional test for the 'net.arnx.fileconv.gradle.plugin.greeting' plugin.
 */
public class FileconvGradlePluginFunctionalTest {
    @Test public void canRunTask() throws IOException {
        // Setup the test build
        File projectDir = new File("build/functionalTest");
        Files.createDirectories(projectDir.toPath());
        writeString(new File(projectDir, "settings.gradle"), "");
        writeString(new File(projectDir, "build.gradle"),
            "plugins {" +
            "  id('net.arnx.fileconv')" +
            "}");

        // Run the build
        GradleRunner runner = GradleRunner.create();
        runner.forwardOutput();
        runner.withPluginClasspath();
        runner.withArguments("fileconv");
        runner.withProjectDir(projectDir);
        BuildResult result = runner.build();

        // Verify the result
        assertTrue(result.getOutput().contains("Hello from plugin 'net.arnx.fileconv'"));
    }

    private void writeString(File file, String string) throws IOException {
        try (Writer writer = new FileWriter(file)) {
            writer.write(string);
        }
    }
}