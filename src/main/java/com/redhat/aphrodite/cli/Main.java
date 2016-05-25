package com.redhat.aphrodite.cli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import org.jboss.set.aphrodite.Aphrodite;
import org.jboss.set.aphrodite.spi.AphroditeException;

public class Main {

    private static Aphrodite aphrodite;
    private static String configPath = "aphrodite.json";

    @Parameter(names = {"--aphroditeconfig", "-ac"}, description = "Change path of aphrodite config", required = false)
    private static String newAphroditePath;

    @Parameter(names = {"--username", "-usr"}, description = "Username for JIRA/BUGZILLA")
    private String username;

    @Parameter(names = {"--password", "-pass"}, description = "Password for JIRA/BUGZILLA")
    private String password;

    public static void main(String... args) throws AphroditeException {
        Main main = new Main();
        new JCommander(main, args);
        if (newAphroditePath != null) {
            configPath = newAphroditePath;
        }
        System.setProperty("aphrodite.config", configPath);
        aphrodite = Aphrodite.instance();
    }
}
