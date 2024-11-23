package menu;

import menuItem.MenuItem;

import java.util.List;

public interface Menu {
    String getTitle();
    String show();
    List<MenuItem> getList();
    boolean getState();
    void setState(boolean state);
}
