import cart.CartImpl;
import menu.BeverageMenuImpl;
import menu.BurgerMenuImpl;
import order.OrderImpl;
import shared.io.input.ConsoleInputImpl;
import shared.io.output.ConsoleOutputImpl;
import kiosk.Kiosk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        new Kiosk(
                new ConsoleInputImpl(scanner),
                new ConsoleOutputImpl(),
                new BurgerMenuImpl(),
                new BeverageMenuImpl(),
                new CartImpl(),
                new OrderImpl()
        ).start();

        scanner.close();
    }
}