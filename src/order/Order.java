package order;

import menuItem.MenuItem;

import java.util.List;

public interface Order {
    double addCartToOrderList(List<MenuItem> menuList, double originalPrice, int ratio);
    List<List<MenuItem>> getOrderList();
    List<Double> getPriceList();
    int getOrderListSize();
    void remove(int commandInput);
}
