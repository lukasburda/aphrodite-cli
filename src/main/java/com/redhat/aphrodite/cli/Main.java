package com.redhat.aphrodite.cli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.jboss.set.aphrodite.Aphrodite;
import org.jboss.set.aphrodite.domain.Issue;
import org.jboss.set.aphrodite.spi.AphroditeException;
import org.jboss.set.aphrodite.spi.NotFoundException;

public class Main {

    private static Aphrodite aphrodite;
    private static String configPath = "aphrodite.json";

    @Parameter(names = {"--aphroditeconfig", "-c"}, description = "Change path of aphrodite config")
    private static String newAphroditePath;

    @Parameter
    private static List<String> addedParams = new ArrayList<>();

//    @Parameter(names = {"--username", "-u"}, description = "Username for JIRA/BUGZILLA")
//    private String username;
//
//    @Parameter(names = {"--password", "-p"}, description = "Password for JIRA/BUGZILLA", password = true)
//    private String password;
    public static void main(String... args) throws AphroditeException, NotFoundException, MalformedURLException {
        Main main = new Main();
        JCommander jcommander = new JCommander(main, args);
        if (newAphroditePath != null) {
            configPath = newAphroditePath;
        }
        for (String urls : addedParams) {
            System.setProperty("aphrodite.config", configPath);
            aphrodite = Aphrodite.instance();
            Issue issue = aphrodite.getIssue(new URL(urls));
            System.out.println(printIssue(issue));
            System.exit(0);
        }
    }

    private static String printIssue(Issue issue) {
        StringBuilder sb = new StringBuilder("");
        sb.append("URL: " + issue.getURL() + "\n")
                .append("TrackerId: " + issue.getTrackerId() + "\n")
                .append("TrackerType: " + issue.getTrackerType() + "\n")
                .append("Product: " + issue.getProduct() + "\n")
                .append("Component: " + issue.getComponents() + "\n")
                .append("Summary: " + issue.getSummary() + "\n")
                .append("Description: " + issue.getDescription() + "\n")
                .append("Assignee: " + issue.getAssignee() + "\n")
                .append("Reporter: " + issue.getReporter() + "\n")
                .append("Stage: " + issue.getStage() + "\n")
                .append("Status: " + issue.getStatus() + "\n")
                .append("Type: " + issue.getType() + "\n")
                .append("Release: " + issue.getReleases() + "\n")
                .append("StreamStatus: " + issue.getStreamStatus() + "\n")
                .append("DependsOn: " + issue.getDependsOn() + "\n")
                .append("Blocks: " + issue.getBlocks() + "\n")
                .append("CreationDate: " + issue.getCreationTime() + "\n")
                .append("LastUpdated: " + issue.getLastUpdated() + "\n")
                .append("Estimation: " + issue.getEstimation() + "\n")
                .append("Comments: " + issue.getComments() + "\n")
                .append("ISSUE END" + "\n");
        return sb.toString();
    }
}
