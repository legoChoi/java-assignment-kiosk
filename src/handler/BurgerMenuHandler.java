package handler;

import cart.Cart;
import menu.Menu;
import menuItem.MenuItem;
import shared.exceptions.exceptions.NotValidInputException;
import shared.io.input.Input;
import shared.io.output.Output;

import java.util.List;

public class BurgerMenuHandler {

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
        int index = 1;


        // 스트림안에서 인덱스를 사용하기위해 AtomicInteger 사용
        view.append("\n[ BURGERS MENU ]\n");

        for (MenuItem item : burgerList) {
            view.append(String.format("%d. %-15s| W %.1f | %s\n",
                    index++,
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
        System.out.println("선택한 메뉴: " + menu.toString());
        cartImpl.addMenuToCart(menu);
    }

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
            }
        }
    }
}
