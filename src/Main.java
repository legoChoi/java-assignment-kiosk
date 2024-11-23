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
import shared.io.output.ConsoleOutputImpl;
import kiosk.Kiosk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Input consoleInputImpl = new ConsoleInputImpl(scanner);

        Cart cartImpl = new CartImpl();
        Order orderImpl = new OrderImpl();

        new Kiosk(
                consoleInputImpl,
                new ConsoleOutputImpl(),
                new BurgerMenuImpl(),
                new BeverageMenuImpl(),
                new CartImpl(),
                new OrderImpl(),

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
                        new OrderImpl()
                )
        ).real();

        scanner.close();
    }
}