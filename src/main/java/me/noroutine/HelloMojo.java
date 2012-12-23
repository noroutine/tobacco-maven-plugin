package me.noroutine;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Say Hello
 *
 */

@Mojo(name = "hello", requiresProject = false, threadSafe = true)
public class HelloMojo extends AbstractMojo {

    public void execute() throws MojoExecutionException {
        getLog().error("Hello, World");
    }
}
