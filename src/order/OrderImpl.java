package order;

import menuItem.MenuItem;
import shared.exceptions.exceptions.OrderListEmptyException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
        this.orderList.add(
                List.copyOf(menuList)
        );
    }

    @Override
    public void remove(int commandInput) {
        orderList.remove(commandInput);
    }

    @Override
    public String show() {
        if (this.orderList.isEmpty()) {
            throw new OrderListEmptyException();
        }
        StringBuilder result = new StringBuilder();
        result.append("\n아래와 같이 주문 하시겠습니까?\n");
        result.append("\n[ Orders ]\n");

        int orderIndex = 1;
        int menuIndex;

        for (List<MenuItem> order : this.orderList) {
            menuIndex = 1;

            result.append(String.format(
                    "\n%d. {",
                    orderIndex++
            ));

            for (MenuItem menu : order) {
                result.append(
                        String.format(
                                "\n\t%d. %-15s | W %.1f | %s",
                                menuIndex++,
                                menu.getName(),
                                menu.getPrice(),
                                menu.getDescription())
                );
            }
            result.append("\n\n\t[Total]");
            result.append(String.format(
                    "\n\tW %.1f",
                    order.stream().mapToDouble(MenuItem::getPrice).sum()
            ));
            result.append("\n}\n");
        }

        result.append("\n제거하려는 주문을 선택해 주세요.\n");
        result.append("0. 종료");

        return result.toString();
    }
}
