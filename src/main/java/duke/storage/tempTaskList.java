package duke.storage;

import duke.ui.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class tempTaskList  {
    private ArrayList<String> list;
    private PropertyChangeSupport support;

    public tempTaskList() {
        list = new ArrayList<String>();
        support = new PropertyChangeSupport(this);
    }

    public void add(String task) {
        var oldlist = list.clone();
        list.add(task);
        support.firePropertyChange("list", oldlist, list);
    }

    public void print() {
        for (int i = 0; i < list.size(); i++) {
            var task = Integer.toString(i+1) + ". " + list.get(i);
            Message.echo(task);
        }
    }

    public String get(int index) {return list.get(index);}
    public Integer size() {return list.size();}

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

}
