package kiosk;

import cartImpl.CartHandler;
import handler.MainMenuHandler;
import handler.MenuHandler;
import order.OrderHandler;

public class Kiosk {

    private final MainMenuHandler mainMenuHandler;
    private final MenuHandler burgerMenuHandler;
    private final MenuHandler beverageMenuHandler;
    private final CartHandler cartHandler;
    private final OrderHandler orderHandler;

    public Kiosk(MainMenuHandler mainMenuHandler, MenuHandler burgerMenuHandler, MenuHandler beverageMenuHandler, CartHandler cartHandler, OrderHandler orderHandler) {
        this.mainMenuHandler = mainMenuHandler;
        this.burgerMenuHandler = burgerMenuHandler;
        this.beverageMenuHandler = beverageMenuHandler;
        this.cartHandler = cartHandler;
        this.orderHandler = orderHandler;
    }

    public void start() {
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
                // 디저트 메뉴 미구현
                return;
            }
            case 4 -> cartHandler.showMenu();
            case 5 -> orderHandler.showMenu();
        }
    }
}