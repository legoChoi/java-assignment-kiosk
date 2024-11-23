package cart;

import menuItem.MenuItem;

import java.util.List;

public interface Cart {
    double getSumPrice();

    void addToCart(MenuItem menuItem);
    void removeFromCart(MenuItem menuItem);
    void clearCartList();
    String show();
    List<MenuItem> getCartList();
    void addMenuToCart(MenuItem menuItem);
}
