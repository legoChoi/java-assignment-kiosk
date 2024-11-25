package kiosk;


import handler.Handler;

public class Kiosk implements Machine {

    private final Handler kioskHandler;
    private final Handler burgerMenuHandler;
    private final Handler beverageMenuHandler;
    private final Handler cartHandler;
    private final Handler orderHandler;

    public Kiosk(Handler mainMenuHandler, Handler burgerMenuHandler, Handler beverageMenuHandler, Handler cartHandler, Handler orderHandler) {
        this.kioskHandler = mainMenuHandler;
        this.burgerMenuHandler = burgerMenuHandler;
        this.beverageMenuHandler = beverageMenuHandler;
        this.cartHandler = cartHandler;
        this.orderHandler = orderHandler;
    }

    @Override
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