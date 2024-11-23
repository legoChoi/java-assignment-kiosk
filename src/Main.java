import cartImpl.Cart;
import cartImpl.CartHandler;
import cartImpl.CartImpl;
import handler.BeverageMenuHandler;
import handler.BurgerMenuHandler;
import menu.BeverageMenuImpl;
import menu.BurgerMenuImpl;
import handler.MainMenuHandler;
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
                new MainMenuHandler(
                        consoleInputImpl
                ),
                new BurgerMenuHandler(
                        consoleInputImpl,
                        new BurgerMenuImpl(),
                        cartImpl
                ),
                new BeverageMenuHandler(
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