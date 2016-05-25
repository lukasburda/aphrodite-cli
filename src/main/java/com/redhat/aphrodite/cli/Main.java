package com.redhat.aphrodite.cli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import org.jboss.set.aphrodite.Aphrodite;
import org.jboss.set.aphrodite.spi.AphroditeException;

public class Main {

    private static Aphrodite aphrodite;
    private static String aphroditeConfigPath = "src/main/resources/aphrodite.json";

    @Parameter(names = {"--aphroditeconfig", "-ac"}, description = "Change path of aphrodite config", required = false)
    String aphroditeConfigPathChange = aphroditeConfigPath;

    @Parameter(names = {"--username", "-usr"}, description = "Username for JIRA/BUGZILLA")
    String username;

    @Parameter(names = {"--password", "-pass"}, description = "Password for JIRA/BUGZILLA")
    String password;

    public static void main(String... args) throws AphroditeException {
        Main main = new Main();
        System.setProperty("aphrodite.config", aphroditeConfigPath);
        new JCommander(main, args);
        aphrodite = Aphrodite.instance();
    }
}
