package cart;

import menuItems.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CartImpl implements Cart {

    private final List<MenuItem> cartItems;
    private boolean state = true;

    public CartImpl() {
        this.cartItems = new ArrayList<>();
    }

    @Override
    public boolean getState() {
        return this.state;
    }

    @Override
    public void setState(boolean state) {
        this.state = state;
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
