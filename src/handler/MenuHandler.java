package handler;

import cartImpl.Cart;
import menu.Menu;
import menuItem.BurgerMenuItemImpl;
import menuItem.MenuItem;
import shared.exceptions.exceptions.NotValidInputException;
import shared.io.input.Input;
import java.util.List;
import java.util.stream.IntStream;

public class MenuHandler extends BaseHandler {

    private final Menu menuImpl;
    private final Cart cartImpl;

    public MenuHandler(Input consoleInputImpl, Menu menuImpl, Cart cartImpl) {
        super(consoleInputImpl);

        this.menuImpl = menuImpl;
        this.cartImpl = cartImpl;
    }

    /**
     *
     * @return 메뉴 리스트 문자열 반환
     */
    private String buildView() {
        StringBuilder view = new StringBuilder();
        List<MenuItem> burgerList = menuImpl.getList();

        view.append("\n[ ").append(this.menuImpl.getTitle()).append(" ]\n");

        IntStream.range(0, burgerList.size())
                .forEach(idx -> {
                    MenuItem menu = burgerList.get(idx);
                    view.append(String.format(
                            "%d. %-15s| W %.1f | %s\n",
                            idx + 1, menu.name(), menu.price(), menu.description()));
                });

        view.append("0. 뒤로가기");

        return view.toString();
    }

    /**
     * 인자로 넘어온 메뉴를 장바구니 리스트에 추가
     * @param menu 추가 할 메뉴
     */
    private void addMenuToCart(MenuItem menu) {
        int response;

        while (true) {
            System.out.println("선택한 메뉴: " + menu.toString());
            System.out.println("\n\"" + menu + "\"");
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.printf("1. %-10s 2. %s%n", "확인", "취소");

            try {
                response = validateCommandInput(1, 2);

                if (response == 1) {
                    cartImpl.addToCart(new BurgerMenuItemImpl(menu.name(), menu.price(), menu.description())); // 복사 생성자를 통한 객체 복사
                    System.out.println(menu.name() + "가 장바구니에 추가되었습니다.");
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

    public void run() {
        int response;

        while (true) {
            try {
                System.out.println(buildView());
                response = validateCommandInput(0, menuImpl.getList().size());

                if (response == 0) {
                    break;
                }
                if (response != -1) {
                    addMenuToCart(menuImpl.getList().get(response - 1));
                }
            } catch (NotValidInputException e) {
                System.out.println(e.getMessage());
                consoleInputImpl.getStringInput();
            }
        }
    }
}
