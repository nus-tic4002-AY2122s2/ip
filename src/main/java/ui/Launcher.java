package ui;

import javafx.application.Application;
import java.Duke;

/**
 * A Launcher class to workaround classpath issues.
 */
public class Launcher {
    public static void main(String[] args) {
        Application.launch(Duke.class, args);
    }
}
