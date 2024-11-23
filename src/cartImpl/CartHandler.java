package cartImpl;

import grade.Grade;
import menuItem.MenuItem;
import order.Order;
import shared.exceptions.exceptions.CartEmptyException;
import shared.exceptions.exceptions.NotValidInputException;
import shared.io.input.Input;
import java.util.List;

public class CartHandler {

    private final Input consoleInputImpl;
    private final Cart cartImpl;
    private final Order orderImpl;

    public CartHandler(Input input, Cart cart, Order orderImpl) {
        this.consoleInputImpl = input;
        this.cartImpl = cart;
        this.orderImpl = orderImpl;
    }

    private int validateCommandInput(int min, int max) {
        int response = consoleInputImpl.getIntInput();

        if (response < min || response > max) {
            throw new NotValidInputException();
        }

        return response;
    }

    private String buildView() {
        List<MenuItem> cartList = cartImpl.getCartList();

        if (this.cartImpl.getCartList().isEmpty()) {
            throw new CartEmptyException();
        }

        StringBuilder view = new StringBuilder();
        int idx = 1;

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
        view.append(String.format("W %.1f\n", cartImpl.getSumPrice()));

        view.append(String.format(
                "\n1. %-10s 2. %-10s 3. %s",
                "주문", "삭제", "메뉴판"
        ));

        return view.toString();
    }

    public void showMenu() {
        int response;

        while (true) {
            try {
                System.out.println(buildView());
                response = validateCommandInput(1, 3);

                if (response == 1) {
                    makeOrderFromCart();
                    break;
                }

                if (response == 2) {
                    deleteMenuFromCart();
                }

                if (response == 3) {
                    break;
                }
            } catch (NotValidInputException e) {
                System.out.println(e.getMessage());
                consoleInputImpl.getStringInput();
            } catch (CartEmptyException e) {
                System.out.println(e.getMessage());
                consoleInputImpl.getStringInput();
                break;
            }
        }
    }

    private void makeOrderFromCart() {
        int response;
        int ratio;
        double price;

        while (true) {
            System.out.println(Grade.getGradeListView());
            try {
                response = validateCommandInput(1, Grade.getLength());
                ratio = Grade.getDiscountRatio(response);
                price = orderImpl.addCartToOrderList(cartImpl.getCartList(), cartImpl.getSumPrice(), ratio);
                System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.%n", price);

                cartImpl.clearCartList();
                break;
            } catch (NotValidInputException e) {
                System.out.println(e.getMessage());
                consoleInputImpl.getStringInput();
            }
        }
    }

    private void deleteMenuFromCart() {
        int response;

        while (true) {
            System.out.println("\n삭제 할 메뉴를 선택 해주세요.");
            System.out.println("0. 취소");

            try {
                response = validateCommandInput(0, cartImpl.getCartList().size());

                if (response == 0) {
                    break;
                }

                cartImpl.removeFromCart(
                        cartImpl.getCartList().get(response -1)
                );
                break;
            } catch (NotValidInputException e) {
                System.out.println(e.getMessage());
                consoleInputImpl.getStringInput();
            }
        }
    }
}
