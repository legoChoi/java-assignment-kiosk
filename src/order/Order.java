package order;

import menuItem.MenuItem;

import java.util.List;

public interface Order {
    double addCartToOrderList(List<MenuItem> menuList, int ratio);
    List<List<MenuItem>> getOrderList();
    String show();
    void remove(int commandInput);
}
