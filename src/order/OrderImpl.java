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

    /**
     * 장바구니에 등록된 메뉴 리스트를 주문 리스트로 옮김
     * @param menuList 장바구니 메뉴 리스트
     * @param originalPrice 할인 전 가격
     * @param ratio 할인율
     * @return 할인 적용된 가격
     */
    @Override
    public double addCartToOrderList(List<MenuItem> menuList, double originalPrice, int ratio) {
        this.orderList.add(List.copyOf(menuList));

        double price = originalPrice * (1 - ratio / 100.0);
        this.priceList.add(price);

        return price;
    }

    /**
     * 인덱스에 맞는 주문 & 가격 삭제
     * @param commandInput
     */
    @Override
    public void remove(int commandInput) {
        orderList.remove(commandInput);
        priceList.remove(commandInput);
    }
}
