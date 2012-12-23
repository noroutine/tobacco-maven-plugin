package me.noroutine;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.*;
import org.apache.maven.plugins.annotations.*;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.project.MavenProject;

import static org.twdata.maven.mojoexecutor.MojoExecutor.*;

/**
 * Shortcut to generate Tobacco application without asking user to enter command line options
 */

@Mojo(name = "generate", requiresProject = false, threadSafe = true)
public class GenerateTobaccoAppMojo extends AbstractMojo {

    @Parameter(required = true, defaultValue = "${project}", readonly = true)
    protected MavenProject project;

    @Parameter(required = true, defaultValue = "${session}", readonly = true)
    protected MavenSession session;

    @Component
    protected BuildPluginManager pluginManager;

    public void execute() throws MojoExecutionException {
        executeMojo(
                plugin("org.apache.maven.plugins", "maven-archetype-plugin", "2.2"),
                "generate",
                configuration(
                        element(name("archetypeGroupId"), "me.noroutine"),
                        element(name("archetypeArtifactId"), "tobacco-bootstrap"),
                        element(name("archetypeVersion"), "1.0.7")
                ),
                executionEnvironment(project, session, pluginManager)
            );
    }
}
