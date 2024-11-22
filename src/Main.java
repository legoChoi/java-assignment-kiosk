import cart.CartImpl;
import menus.BeverageMenuImpl;
import menus.BurgerMenuImpl;
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
                new CartImpl()
        ).start();

        scanner.close();
    }
}