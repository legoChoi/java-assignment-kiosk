package menu;

import menuItem.MenuItem;

import java.util.List;

public interface Menu {
    String getTitle();
    List<MenuItem> getList();
}
