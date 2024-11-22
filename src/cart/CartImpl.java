package cart;

import menuItems.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CartImpl implements Cart {

    private final List<MenuItem> cartItems;

    public CartImpl() {
        this.cartItems = new ArrayList<>();
    }

    @Override
    public void add(MenuItem menuItem) {
        this.cartItems.add(menuItem);
    }

    @Override
    public void remove(MenuItem menuItem) {
        this.cartItems.stream()
                .filter(item -> item.equals(menuItem))
                .toList()
                .forEach(this.cartItems::remove);
    }
}
