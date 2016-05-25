package com.redhat.aphrodite.cli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class Main {

    @Parameter(names = {"--length", "-l"})
    int length;

    public static void main(String... args) {
        Main main = new Main();
        new JCommander(main, args);
        main.run();
    }

    public void run() {
        System.out.printf("%d", length);
    }
}
