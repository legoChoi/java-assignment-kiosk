import cart.Cart;
import cart.CartImpl;
import handler.BeverageMenuHandler;
import handler.BurgerMenuHandler;
import menu.BeverageMenuImpl;
import menu.BurgerMenuImpl;
import handler.MainMenuHandler;
import menuItem.BurgerMenuItemImpl;
import order.OrderImpl;
import shared.io.input.ConsoleInputImpl;
import shared.io.input.Input;
import shared.io.output.ConsoleOutputImpl;
import kiosk.Kiosk;
import shared.io.output.Output;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Input consoleInputImpl = new ConsoleInputImpl(scanner);
        Output consoleOutputImpl = new ConsoleOutputImpl();

        Cart cart = new CartImpl();

        new Kiosk(
                consoleInputImpl,
                new ConsoleOutputImpl(),
                new BurgerMenuImpl(),
                new BeverageMenuImpl(),
                new CartImpl(),
                new OrderImpl(),

                new MainMenuHandler(
                        consoleInputImpl,
                        consoleOutputImpl
                ),
                new BurgerMenuHandler(
                        consoleInputImpl,
                        new BurgerMenuImpl(),
                        cart
                ),
                new BeverageMenuHandler(
                        consoleInputImpl,
                        new BeverageMenuImpl(),
                        cart
                )
        ).real();

        scanner.close();
    }
}