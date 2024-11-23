package kiosk;

import cart.Cart;
import handler.BeverageMenuHandler;
import handler.BurgerMenuHandler;
import handler.MainMenuHandler;
import menu.Menu;
import order.Order;
import shared.io.input.Input;
import shared.io.output.Output;

public class Kiosk {
    private final Menu burgerMenu;
    private final Menu beverageMenu;
    private boolean state = true;
    private final Input consoleInput;
    private final Output consoleOutput;
    private final Cart cart;
    private final Order order;

    private final MainMenuHandler mainMenuHandler;
    private final BurgerMenuHandler burgerMenuHandler;
    private final BeverageMenuHandler beverageMenuHandler;

    public Kiosk(Input consoleInput, Output consoleOutput, Menu burgerMenu, Menu beverageMenu, Cart cart, Order order, MainMenuHandler mainMenuHandler, BurgerMenuHandler burgerMenuHandler, BeverageMenuHandler beverageMenuHandler) {
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;
        this.burgerMenu = burgerMenu;
        this.beverageMenu = beverageMenu;
        this.cart = cart;
        this.order = order;

        this.mainMenuHandler = mainMenuHandler;
        this.burgerMenuHandler = burgerMenuHandler;
        this.beverageMenuHandler = beverageMenuHandler;
    }

    public void real() {
        int response;

        while (true) {
            response = mainMenuHandler.showMenu();
            if (response == 0) {
                break;
            }

            handleMenu(response);
        }
    }

    private void handleMenu(int response) {
        switch (response) {
            case 1 -> burgerMenuHandler.showMenu();
            case 2 -> beverageMenuHandler.showMenu();
            case 3 -> {
                return;
            }
            case 4 -> {
                return;
            }
            case 5 -> {
                return;
            }
            case 6 -> {
                return;
            }
        }
    }
//
//
//
//    /**
//     *
//     * @return 현재 인스턴스의 state 값
//     */
//    private boolean getState() {
//        return state;
//    }
//
//    /**
//     *
//     * @param state 변환할 state 값
//     */
//    private void setState(boolean state) {
//        this.state = state;
//    }
//
//    /** 메인 메뉴 보여주는 메소드 **/
//    private void showMainMenu() {
//        String mainMenu = "\n[ MAIN MENU ]\n" +
//                "1. Burgers\n" +
//                "2. Drinks\n" +
//                "3. Desserts\n" +
//                String.format("0. %-13s | %s", "종료", "종료");
//
//        consoleOutput.print(mainMenu);
//
//        String orderMenu = "\n[ ORDER MENU ]\n" +
//                String.format("4. %-13s | %s\n", "Orders", "장바구니를 확인 후 주문합니다.") +
//                String.format("5. %-13s | %s", "Cancel", "진행중인 주문을 취소합니다.");
//
//        consoleOutput.print(orderMenu);
//    }
//
//    public void start() {
//        int commandInput;
//
//        while (getState()) {
//            showMainMenu();
//
//            try {
//                commandInput = consoleInput.getIntInput();
//
//                setState(switchMenuByCommandInput(commandInput));
//            } catch (NotValidInputException | CartEmptyException | OrderListEmptyException e) {
//                consoleOutput.print(e.getMessage());
//                consoleInput.getStringInput(); // 개행 문자 처리
//            }
//        }
//    }
//
//    /**
//     * 입력받은 정수 명령어 값에 해당하는 메뉴 분기 메소드
//     * @param commandInput 명령어 콘솔 입력 값 : 정수
//     * @return setState 할 boolean 값 반환
//     */
//    private boolean switchMenuByCommandInput(int commandInput) {
//        if (commandInput == 0) {
//            return false;
//        }
//        else if (commandInput == 1) {
//            showMenuBranch(burgerMenu);
//            return true;
//        }
//        else if (commandInput == 2) {
//            showMenuBranch(beverageMenu);
//            return true;
//        }
//        else if (commandInput == 3) { // 디저트 메뉴는 아직 없음
//            return true;
//        }
//        else if (commandInput == 4) { // cart to order
//            // 장바구니 확인 후 주문 & 취소 로직
//            showCartMenuBranch();
//            return true;
//        }
//        else if (commandInput == 5) { // order cancel
//            // 진행중인 주문 확인 후 취소 로직
//            deleteFromOrderList();
//            return true;
//        }
//        else {
//            throw new NotValidInputException();
//        }
//    }
//
//    public int validateCommandInput() {
//        try {
//            int commandInput = consoleInput.getIntInput();
//
//            return commandInput;
//        } catch (NotValidInputException e) {
//            consoleOutput.print(e.getMessage());
//            consoleInput.getStringInput();
//            return -1;
//        }
//    }
//
//    /**
//     * Menu 구현체의 메뉴 리스트를 보여주는 메소드
//     * @param menu Menu 구현체
//     */
//    private void showMenuBranch(Menu menu) {
//        int commandInput;
//        List<MenuItem> menuItemList = menu.getList();
//        MenuItem menuItem;
//
//        while (true) {
//            consoleOutput.print(menu.show());
//            commandInput = validateCommandInput();
//
//            if (commandInput == 0) {
//                break;
//            } else if (commandInput > 0 && commandInput < menuItemList.size()) {
//                menuItem = menuItemList.get(commandInput - 1);
//
//                consoleOutput.print(menuItem.toString());
//
//                addMenuToCart(menuItem);
//                break;
//            }
//        }
//    }
//
//    private void addMenuToCart(MenuItem menuItem) {
//        int commandInput;
//
//        while (true) {
//            consoleOutput.print("\n위 메뉴를 장바구니에 추가하시겠습니까?");
//            consoleOutput.print(String.format(
//                    "1. %-10s 2. %s",
//                    "확인", "취소"
//            ));
//
//            commandInput = validateCommandInput();
//
//            if (commandInput == 1) {
//                cart.addToCart(menuItem);
//                consoleOutput.print(menuItem.getName() + "이 장바구니에 추가되었습니다.");
//                break;
//            }
//            else if (commandInput == 2) {
//                break;
//            } else {
////                consoleOutput.print(ExceptionMessages.NOT_VALID_MENU_INPUT.getMessage());
//            }
//        }
//    }
//
//    private void showCartMenuBranch() {
//        int commandInput;
//
//        while (true) {
//            consoleOutput.print(cart.show());
//
//            try {
//                commandInput = consoleInput.getIntInput();
//
//                if (commandInput == 1) { // Cart to Order
//                    int ratio = checkGradeForDiscount();
//                    double price = order.addCartToOrderList(cart.getCartList(), ratio);
//                    cart.clearCartList();
//
//                    consoleOutput.print(String.format(
//                            "주문이 완료되었습니다. 금액은 W %.1f 입니다.",
//                            price
//                    ));
//                    break;
//                } else if (commandInput == 2) { // 장바구니에서 삭제 후 다시 시작
//                    deleteFromCart();
//                } else if (commandInput == 3) { // 나가기
//                    break;
//                }
//                 else {
//                    throw new NotValidInputException();
//                }
//            } catch (NotValidInputException e) {
//                consoleOutput.print(e.getMessage());
//                consoleInput.getStringInput();
//            }
//        }
//    }
//
//    private void deleteFromCart() {
//        int commandInput;
//
//        while (true) {
//            consoleOutput.print("\n삭제 할 메뉴를 선택 해주세요.");
//            consoleOutput.print("0. 취소");
//
//            try {
//                commandInput = consoleInput.getIntInput();
//
//                if (commandInput == 0) {
//                    break;
//                } else if (commandInput < 0 || commandInput > cart.getCartList().size()) {
//                    throw new NotValidInputException();
//                }
//
//                cart.removeFromCart(
//                        cart.getCartList().get(commandInput -1)
//                );
//
//                break;
//            } catch (NotValidInputException e) {
//                consoleOutput.print(e.getMessage());
//                consoleInput.getStringInput();
//            }
//        }
//    }
//
//    private int checkGradeForDiscount() {
//        int commandInput;
//        int length = Grade.getLength();
//
//        while (true) {
//            try {
//                consoleOutput.print(Grade.getGradList());
//
//                commandInput = consoleInput.getIntInput();
//
//                if (commandInput < 1 || commandInput > length) {
//                    throw new NotValidInputException();
//                }
//
//                return Grade.getDiscountRatio(commandInput);
//            } catch (NotValidInputException e) {
//                consoleOutput.print(e.getMessage());
//                consoleInput.getStringInput();
//            }
//        }
//    }
//
//    private void deleteFromOrderList() {
//        int commandInput;
//        while (true) {
//            consoleOutput.print(order.show());
//            try{
//                commandInput = consoleInput.getIntInput();
//
//                if (commandInput == 0) {
//                    break;
//                } else if (commandInput > 0 && commandInput < order.getOrderList().size() + 1) {
//                    order.remove(commandInput - 1);
//                    break;
//                }
//
//                throw new NotValidInputException();
//
//            } catch (NotValidInputException e) {
//                consoleOutput.print(e.getMessage());
//                consoleInput.getStringInput();
//            }
//        }
//    }
}
