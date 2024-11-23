package order;

import cart.Cart;
import shared.exceptions.exceptions.OrderListEmptyException;
import shared.io.input.Input;

public class OrderHandler {

    private final Input consoleInput;
    private final Cart cart;
    private final Order order;

    public OrderHandler(Input consoleInput, Cart cart, Order order) {
        this.consoleInput = consoleInput;
        this.cart = cart;
        this.order = order;
    }

    private String buildView() {
        StringBuilder view = new StringBuilder();

        if (order.getOrderList().isEmpty()) {
            throw new OrderListEmptyException();
        }

        return view.toString();
    }

    public void showMenu() {
        try {
            System.out.println(buildView());
        } catch (OrderListEmptyException e) {
            System.out.println(e.getMessage());
            consoleInput.getStringInput();
        }
    }
}
