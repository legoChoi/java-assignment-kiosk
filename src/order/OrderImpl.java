package order;

import menuItem.MenuItem;
import shared.exceptions.exceptions.OrderListEmptyException;

import java.util.ArrayList;
import java.util.List;

public class OrderImpl implements Order {
    private final List<List<MenuItem>> orderList;
    private final List<Double> priceList;

    public OrderImpl() {
        this.orderList = new ArrayList<>();
        this.priceList = new ArrayList<>();
    }

    @Override
    public List<List<MenuItem>> getOrderList() {
        return this.orderList;
    }

    @Override
    public double addCartToOrderList(List<MenuItem> menuList, double originalPrice, int ratio) {
        this.orderList.add(
                List.copyOf(menuList)
        );

        double price = originalPrice * (1 - ratio / 100.0);
        this.priceList.add(price);

        return price;
    }

    @Override
    public void remove(int commandInput) {
        orderList.remove(commandInput);
        priceList.remove(commandInput);
    }

    @Override
    public String show() {
        if (this.orderList.isEmpty()) {
            throw new OrderListEmptyException();
        }
        StringBuilder result = new StringBuilder();
        result.append("\n[ Orders ]\n");

        int orderIndex = 1;
        int pos = 0;

        for (List<MenuItem> order : this.orderList) {

            result.append(String.format(
                    "%d.",
                    orderIndex++
            ));

            for (MenuItem menu : order) {
                result.append(
                        String.format(
                                "\n%-15s | W %.1f | %s",
                                menu.getName(),
                                menu.getPrice(),
                                menu.getDescription())
                );
            }
            result.append("\n\n[Total]");
            result.append(String.format(
                    "\nW %.1f\n\n",
                    this.priceList.get(pos++)
            ));
        }

        result.append("제거하려는 주문을 선택해 주세요.\n");
        result.append("0. 종료");

        return result.toString();
    }
}
