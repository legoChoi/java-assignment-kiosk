import cartImpl.Cart;
import handler.CartHandler;
import cartImpl.CartImpl;
import handler.*;
import handler.KioskHandler;
import menu.BeverageMenuImpl;
import menu.BurgerMenuImpl;
import order.Order;
import handler.OrderHandler;
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
                new MenuHandler(
                        consoleInputImpl,
                        new BurgerMenuImpl(),
                        cartImpl
                ),
                new MenuHandler(
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
                        orderImpl
                )
        ).start();

        scanner.close();
    }
}