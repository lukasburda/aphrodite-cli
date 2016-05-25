package com.redhat.aphrodite.cli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class Main {

    @Parameter(names = {"--username", "-usr"})
    String username;
    @Parameter(names = {"--password", "-pass"})
    String password;

    public static void main(String... args) {
        Main main = new Main();
        new JCommander(main, args);
        main.run();
    }

    public void run() {
        System.out.printf("%s %s", username, password);
    }
}
