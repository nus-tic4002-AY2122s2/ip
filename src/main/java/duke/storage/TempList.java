package duke.storage;

import duke.ui.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;

public class TempList<T> implements Iterable<T>{
    private ArrayList<T> list;
    private PropertyChangeSupport support;

    public TempList() {
        list = new ArrayList<T>();
        support = new PropertyChangeSupport(this);
    }

    public void add(T task) {
        var oldlist = list.clone();
        list.add(task);
        support.firePropertyChange("list", oldlist, list);
    }




    public T get(int index) {return list.get(index);}
    public Integer size() {return list.size();}

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
