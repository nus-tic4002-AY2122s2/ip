package duke.storage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class TempList<T> implements Iterable<T>{
    protected ArrayList<T> list;
    protected PropertyChangeSupport support;

    public TempList() {
        list = new ArrayList<T>();
        support = new PropertyChangeSupport(this);
    }

    public void add(T element) {
        var oldlist = list.clone();
        list.add(element);
        support.firePropertyChange("list", oldlist, list);
    }

    public void removeAt(int index) {
        var oldlist = list.clone();
        list.remove(index);
        support.firePropertyChange("list", oldlist, list);
    }

    public Stream<T> stream() {
        return list.stream();
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
