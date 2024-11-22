package cart;

import menuItems.MenuItem;

public interface Cart {
    boolean getState();
    void setState(boolean state);
    void add(MenuItem menuItem);
    void remove(MenuItem menuItem);
}
