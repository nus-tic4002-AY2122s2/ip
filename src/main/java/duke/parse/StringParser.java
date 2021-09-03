package duke.parse;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;

public class StringParser {
    private String[] keyArgs;
    private PropertyChangeSupport support;

    public StringParser() {
        support = new PropertyChangeSupport(this);
    }

    public void passToCaller(String line) {
        keyArgs = line.strip().split(" ");

        support.firePropertyChange("keyArgs", null, keyArgs);
    }


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
