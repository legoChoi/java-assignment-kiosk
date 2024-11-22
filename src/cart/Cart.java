package cart;

import menuItem.MenuItem;

import java.util.List;

public interface Cart {
    boolean getState();
    void setState(boolean state);
    void add(MenuItem menuItem);
    void removeFromCart(MenuItem menuItem);
    void clearCartList();
    String show();
    List<MenuItem> getCartList();
}
