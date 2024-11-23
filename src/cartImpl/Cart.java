package cartImpl;

import menuItem.MenuItem;

import java.util.List;

public interface Cart {
    double getSumPrice();
    void addToCart(MenuItem menuItem);
    void removeFromCart(MenuItem menuItem);
    void clearCartList();
    List<MenuItem> getCartList();
}
