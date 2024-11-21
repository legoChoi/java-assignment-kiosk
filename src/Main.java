import menus.BeverageMenu;
import menus.BurgerMenu;
import menus.Menu;
import shared.io.input.ConsoleInput;
import shared.io.input.Input;
import shared.io.output.ConsoleOutput;
import shared.io.output.Output;
import kiosk.Kiosk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Input consoleInput = new ConsoleInput(scanner);
        Output consoleOutput = new ConsoleOutput();

        Menu burgerMenu = new BurgerMenu(consoleOutput);
        Menu beverageMenu = new BeverageMenu(consoleOutput);

        new Kiosk(
                consoleInput,
                consoleOutput,
                burgerMenu,
                beverageMenu
        );

        scanner.close();
    }
}