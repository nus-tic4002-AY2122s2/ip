package UserList;

import java.util.ArrayList;

public class UserList {
    private ArrayList<String> list = new ArrayList<>();

    public void addItem (String item){
        this.list.add((item));
    }

    public ArrayList<String> getList() { return this.list; }
}
