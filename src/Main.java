import menus.BeverageMenuImpl;
import menus.BurgerMenuImpl;
import shared.io.input.ConsoleInput;
import shared.io.output.ConsoleOutput;
import kiosk.Kiosk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        new Kiosk(
                new ConsoleInput(scanner),
                new ConsoleOutput(),
                new BurgerMenuImpl(),
                new BeverageMenuImpl()
        );

        scanner.close();
    }
}