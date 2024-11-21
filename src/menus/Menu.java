package menus;

import menuItems.MenuItem;

import java.util.List;

public interface Menu {
    void show();
    List<MenuItem> getList();
    boolean getState();
    void setState(boolean state);
}
