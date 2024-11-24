import cartImpl.Cart;
import cartImpl.CartHandler;
import cartImpl.CartImpl;
import menuHandler.*;
import kiosk.KioskHandler;
import menu.BeverageMenuImpl;
import menu.BurgerMenuImpl;
import order.Order;
import order.OrderHandler;
import order.OrderImpl;
import shared.io.input.ConsoleInputImpl;
import shared.io.input.Input;
import kiosk.Kiosk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Input consoleInputImpl = new ConsoleInputImpl(scanner);

        Cart cartImpl = new CartImpl();
        Order orderImpl = new OrderImpl();

        new Kiosk(
                new KioskHandler(
                        consoleInputImpl
                ),
                new MenuHandlerImpl(
                        consoleInputImpl,
                        new BurgerMenuImpl(),
                        cartImpl
                ),
                new MenuHandlerImpl(
                        consoleInputImpl,
                        new BeverageMenuImpl(),
                        cartImpl
                ),
                new CartHandler(
                        consoleInputImpl,
                        cartImpl,
                        orderImpl
                ),
                new OrderHandler(
                        consoleInputImpl,
                        cartImpl,
                        orderImpl
                )
        ).start();

        scanner.close();
    }
}