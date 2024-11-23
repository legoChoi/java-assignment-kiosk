package handler;

import cart.Cart;
import menu.Menu;
import menuItem.MenuItem;
import shared.exceptions.exceptions.NotValidInputException;
import shared.io.input.Input;

import java.util.List;

public class BurgerMenuHandler implements MenuHandler {

    private final Input consoleInputImpl;
    private final Menu burgerMenuImpl;
    private final Cart cartImpl;

    public BurgerMenuHandler(Input consoleInput, Menu burgerMenu, Cart cart) {
        this.consoleInputImpl = consoleInput;
        this.burgerMenuImpl = burgerMenu;
        this.cartImpl = cart;
    }

    private String buildView() {
        StringBuilder view = new StringBuilder();
        List<MenuItem> burgerList = burgerMenuImpl.getList();
        int idx = 1;

        view.append("\n[ ").append(this.burgerMenuImpl.getTitle()).append(" ]\n");

        for (MenuItem item : burgerList) {
            view.append(String.format("%d. %-15s| W %.1f | %s\n",
                    idx++,
                    item.getName(),
                    item.getPrice(),
                    item.getDescription()));
        }
        view.append("0. 뒤로가기");

        return view.toString();
    }

    private int validateCommandInput(int min, int max) {
        try {
            int response = consoleInputImpl.getIntInput();

            if (response < min || response > max) {
                throw new NotValidInputException();
            }

            return response;
        } catch (NotValidInputException e) {
            System.out.println(e.getMessage());
            consoleInputImpl.getStringInput();
            return -1;
        }
    }

    private void addMenuToCart(MenuItem menu) {
        while (true) {
            System.out.println("선택한 메뉴: " + menu.toString());
            System.out.println("\n\"" + menu + "\"");
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.printf("1. %-10s 2. %s%n", "확인", "취소");

            try {
                int response = validateCommandInput(1, 2);

                if (response == 1) {
                    cartImpl.addToCart(menu);
                    System.out.println(menu.getName() + "가 장바구니에 추가되었습니다.");
                    break;
                }

                if (response == 2) {
                    break;
                }

            } catch (NotValidInputException e) {
                System.out.println(e.getMessage());
                consoleInputImpl.getStringInput();
            }
        }
    }

    @Override
    public void showMenu() {
        int response;

        while (true) {
            System.out.println(buildView());
            response = validateCommandInput(0, burgerMenuImpl.getList().size());

            if (response == 0) {
                break;
            }

            if (response != -1) {
                addMenuToCart(burgerMenuImpl.getList().get(response - 1));
                break;
            }
        }
    }
}
