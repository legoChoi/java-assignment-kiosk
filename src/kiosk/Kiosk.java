package kiosk;

import handler.CartHandler;
import handler.KioskHandler;
import handler.MenuHandler;
import handler.OrderHandler;

public class Kiosk {

    private final KioskHandler kioskHandler;
    private final MenuHandler burgerMenuHandler;
    private final MenuHandler beverageMenuHandler;
    private final CartHandler cartHandler;
    private final OrderHandler orderHandler;

    public Kiosk(KioskHandler mainMenuHandler, MenuHandler burgerMenuHandler, MenuHandler beverageMenuHandler, CartHandler cartHandler, OrderHandler orderHandler) {
        this.kioskHandler = mainMenuHandler;
        this.burgerMenuHandler = burgerMenuHandler;
        this.beverageMenuHandler = beverageMenuHandler;
        this.cartHandler = cartHandler;
        this.orderHandler = orderHandler;
    }

    public void start() {
        int response;

        while (true) {
            response = kioskHandler.run();

            if (response == 0) {
                break;
            }

            handleMenu(response);
        }
    }

    private void handleMenu(int response) {
        switch (response) {
            case 1 -> burgerMenuHandler.run();
            case 2 -> beverageMenuHandler.run();
            case 3 -> {
                // 디저트 메뉴 미구현
            }
            case 4 -> cartHandler.run();
            case 5 -> orderHandler.run();
        }
    }
}