package order;

import menuItem.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class OrderImpl implements Order {

    private final List<List<MenuItem>> orderList;
    private final List<Double> priceList;

    /**
     * 주문 목록과 동일한 인덱스에 주문 가격
     */
    public OrderImpl() {
        this.orderList = new ArrayList<>();
        this.priceList = new ArrayList<>();
    }

    @Override
    public double addCartToOrderList(List<MenuItem> menuList, double originalPrice, int ratio) {
        this.orderList.add(List.copyOf(menuList));

        double price = originalPrice * (1 - ratio / 100.0);
        this.priceList.add(price);

        return price;
    }

    @Override
    public List<List<MenuItem>> getOrderList() {
        return this.orderList;
    }

    @Override
    public List<Double> getPriceList() {
        return this.priceList;
    }

    @Override
    public int getOrderListSize() {
        return this.orderList.size();
    }

    @Override
    public void remove(int idx) {
        orderList.remove(idx);
        priceList.remove(idx);
    }
}
