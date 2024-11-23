package cart;

import menuItem.MenuItem;
import shared.exceptions.exceptions.CartEmptyException;
import shared.io.input.Input;

import java.util.List;

public class CartHandler {

    private final Input conosoleInpput;
    private final Cart cart;

    public CartHandler(Input input, Cart cart) {
        this.conosoleInpput = input;
        this.cart = cart;
    }

    private String buildView() {
        StringBuilder view = new StringBuilder();
        List<MenuItem> cartList = cart.getCartList();
        int idx = 1;

        if (cartList.isEmpty()) {
            throw new CartEmptyException();
        }

        view.append("\n[ ORDER MENU ]\n");

        for (MenuItem item : cartList) {
            view.append(String.format(
                    "%d. %-15s| W %.1f | %s\n",
                    idx++,
                    item.getName(),
                    item.getPrice(),
                    item.getDescription()));
        }

        view.append("\n[ Total ]\n");
        view.append(String.format("W %.1f\n", cart.getSumPrice()));

        view.append(String.format(
                "\n1. %-10s 2. %-10s 3. %s",
                "주문", "삭제", "메뉴판"
        ));

        return view.toString();
    }

    public void showMenu() {
        try {
            System.out.println(buildView());


        } catch (CartEmptyException e) {
            System.out.println(e.getMessage());
            conosoleInpput.getStringInput();
        }
    }
}
