package order;

import cartImpl.Cart;
import menuItem.MenuItem;
import shared.exceptions.exceptions.NotValidInputException;
import shared.exceptions.exceptions.OrderListEmptyException;
import shared.io.input.Input;

import java.util.List;

public class OrderHandler {

    private final Input consoleInputImpl;
    private final Cart cart;
    private final Order orderImpl;

    public OrderHandler(Input consoleInput, Cart cart, Order order) {
        this.consoleInputImpl = consoleInput;
        this.cart = cart;
        this.orderImpl = order;
    }

    private int validateCommandInput(int min, int max) {
        int response = consoleInputImpl.getIntInput();

        if (response < min || response > max) {
            throw new NotValidInputException();
        }

        return response;
    }

    private String buildView() {
        if (orderImpl.getOrderListSize() == 0) {
            throw new OrderListEmptyException();
        }

        StringBuilder view = new StringBuilder();
        List<List<MenuItem>> orderList = this.orderImpl.getOrderList();
        List<Double> priceList = this.orderImpl.getPriceList();
        int orderIndex = 1;
        int pos = 0;

        view.append("\n[ Orders ]\n");

        for (List<MenuItem> order : orderList) {
            view.append(String.format("%d.", orderIndex++));

            for (MenuItem menu : order) {
                view.append("\n");
                view.append(menu.toString());
            }

            view.append("\n[Total]");
            view.append(String.format(
                    "\nW %.1f\n\n",
                    priceList.get(pos++)
            ));
        }

        view.append("제거하려는 주문을 선택해 주세요.\n");
        view.append("0. 종료");

        return view.toString();
    }

    public void showMenu() {
        int response;

        while (true) {
            try {
                System.out.println(buildView());
                response = validateCommandInput(0, orderImpl.getOrderList().size());

                if (response == 0) {
                    break;
                }

                orderImpl.remove(response - 1);
                break;
            } catch (NotValidInputException e) {
                System.out.println(e.getMessage());
                consoleInputImpl.getStringInput();
            } catch (OrderListEmptyException e) {
                System.out.println(e.getMessage());
                consoleInputImpl.getStringInput();
                break;
            }
        }
    }
}
