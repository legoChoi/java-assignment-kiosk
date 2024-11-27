package handler;

import cart.Cart;
import grade.Grade;
import menuItem.MenuItem;
import order.Order;
import shared.exceptions.exceptions.CartEmptyException;
import shared.exceptions.exceptions.NotValidInputException;
import shared.io.input.Input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CartHandler implements Handler {

    private final Input consoleInputImpl;
    private final Cart cartImpl;
    private final Order orderImpl;

    public CartHandler(Input consoleInputImpl, Cart cart, Order orderImpl) {
        this.consoleInputImpl = consoleInputImpl;
        this.cartImpl = cart;
        this.orderImpl = orderImpl;
    }

    @Override
    public int run() {
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

        return -1;
    }

    /**
     * 정수 입력 값 검증
     * @param min 입력 가능한 최솟값
     * @param max 입력 가능한 최댓값
     * @return 검증된 입력값
     * @throws NotValidInputException
     */
    private int validateCommandInput(int min, int max) {
        int response = consoleInputImpl.getIntInput();

        if (response < min || response > max) {
            throw new NotValidInputException();
        }

        return response;
    }

    /**
     *
     * @return 장바구니 리스트 문자열 반환
     */
    private String buildView() {
        List<MenuItem> cartList = cartImpl.getCartList();

        if (this.cartImpl.getCartList().isEmpty()) {
            throw new CartEmptyException();
        }

        StringBuilder view = new StringBuilder();

        view.append("\n[ ORDER MENU ]\n");

        IntStream.range(0, cartList.size())
                .forEach(idx -> {
                    MenuItem menu = cartList.get(idx);
                    view.append(String.format(
                            "%d. %-15s| W %.1f | %s\n",
                            idx + 1,
                            menu.name(),
                            menu.price(),
                            menu.description()));
                });

        view.append("\n[ Total ]\n");
        view.append(String.format("W %.1f\n", cartImpl.getSumPrice()));
        view.append(String.format(
                "\n1. %-10s 2. %-10s 3. %s",
                "주문", "삭제", "메뉴판"
        ));

        return view.toString();
    }

    /**
     * 장바구니에 있는 메뉴 리스트를 주문 리스트에 삽입하는 메소드
     */
    private void makeOrderFromCart() {
        int response;
        int ratio;
        double price;

        while (true) {
            System.out.println(buildGradeListView());
            try {
                response = validateCommandInput(1, Grade.getLength());
                ratio = Grade.getDiscountRatio(response);
                price = orderImpl.addCartToOrderList(cartImpl.getCartList(), cartImpl.getSumPrice(), ratio);
                System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.%n", price);

                cartImpl.initCartList();
                break;
            } catch (NotValidInputException e) {
                System.out.println(e.getMessage());
                consoleInputImpl.getStringInput();
            }
        }
    }

    /**
     * 할인 등급 리스트를 문자열로 반환하는 메소드
     */
    private String buildGradeListView() {
        StringBuilder view = new StringBuilder();
        view.append("\n할인 정보를 입력해주세요.");

        Arrays.stream(Grade.values()).forEach(grade ->
                view.append(String.format(
                        "\n%d. %-13s : %d%%",
                        grade.getIndex(),
                        grade.getName(),
                        grade.getRatio()
                )));

        return view.toString();
    }

    /**
     * 장바구니에서 특정 메뉴 삭제 메소드
     */
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
