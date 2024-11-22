package order;

import menuItem.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderImpl implements Order {
    private final List<List<MenuItem>> orderList;

    public OrderImpl() {
        this.orderList = new ArrayList<>();
    }

    @Override
    public List<List<MenuItem>> getOrderList() {
        return this.orderList;
    }

    @Override
    public void addCartToOrderList(List<MenuItem> menuList) {
        this.orderList.add(menuList);
    }

    @Override
    public String show(List<List<MenuItem>> menuList) {
        StringBuilder result = new StringBuilder();
        result.append("\n아래와 같이 주문 하시겠습니까?\n");



        return result.toString();
    }
}
