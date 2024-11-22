package cart;

import menuItems.MenuItem;

public interface Cart {
    void add(MenuItem menuItem);
    void remove(MenuItem menuItem);
}
