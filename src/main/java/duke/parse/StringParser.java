package duke.parse;

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

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

}
