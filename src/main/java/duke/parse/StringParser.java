package duke.parse;

import duke.task.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * StringParser acts like a utility that offers methods
 * that parse strings for different purposes and outcomes
 * After parsing, it will fire the Property Change
 * So that listener could take action on the result
 */
public class StringParser {
    private String[] keyArgs;
    private PropertyChangeSupport support;

    public StringParser() {
        support = new PropertyChangeSupport(this);
    }

    /**
     * Get a String divide it as first word command key
     * the rest consider as arguments for the command
     * @param line
     */
    public void passToCaller(String line) {
        keyArgs = line.strip().split(" ");

        support.firePropertyChange("keyArgs", null, keyArgs);
    }

    /**
     * Take a String Array and remove the first element
     * @param xxs
     * @return String without the first element
     */
    public static String[] removeFirst(String[] xxs) {
        String[] xs = new String[xxs.length - 1];
        for (int i = 1; i < xxs.length; i++) {
            xs[i - 1] = xxs[i];
        }
        return xs;
    }


    public static String join(String[] args) {
        String arg = "";
        for (String word : args) {
            arg += word + " ";
        }
        return arg.strip();
    }

    public static Task stringToTask(String line) {
        String[] parts = line.split("]", 3);
        Boolean isDone = !parts[1].equals("[ ")? true : false;

        Task res;
        String[] args;

        switch (parts[0]) {
            case "[T":
                res = new Todo(parts[2]);
                break;
            case "[E":
                args = parts[2].split("/at");
                res = new Event(args[0], args[1]);
                break;
            case "[D":
                args = parts[2].split("/by");
                res = new Deadline(args[0], args[1]);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + parts[0]);
        }

        if (isDone) {
            res.markDone();
        }
        return res;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

}
