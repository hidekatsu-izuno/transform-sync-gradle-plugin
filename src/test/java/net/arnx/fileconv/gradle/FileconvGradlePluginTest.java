package net.arnx.fileconv.gradle;

import org.gradle.testfixtures.ProjectBuilder;
import org.gradle.api.Project;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A simple unit test for the 'net.arnx.fileconv' plugin.
 */
public class FileconvGradlePluginTest {
    @Test public void pluginRegistersATask() {
        // Create a test project and apply the plugin
        Project project = ProjectBuilder.builder().build();
        project.getPlugins().apply("net.arnx.fileconv");

        // Verify the result
        assertNotNull(project.getTasks().findByName("fileconv"));
    }
}