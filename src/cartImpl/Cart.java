package cartImpl;

import menuItem.MenuItem;

import java.util.List;

public interface Cart {
    double getSumPrice();
    void setCartList(List<MenuItem> cartList);
    void addToCart(MenuItem menuItem);
    void removeFromCart(MenuItem menuItem);
    void initCartList();
    List<MenuItem> getCartList();
}
