package order;

import menuItem.MenuItem;

import java.util.List;

public interface Order {
    void addCartToOrderList(List<MenuItem> menuList);
    List<List<MenuItem>> getOrderList();
    String show();
    void remove(int commandInput);
}
