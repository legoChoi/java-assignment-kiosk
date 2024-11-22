package shared.io.input;

import shared.exceptions.exceptions.NotValidInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInputImpl implements Input {
    private Scanner scanner;

    public ConsoleInputImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int getIntInput() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new NotValidInputException();
        }
    }

    @Override
    public String getStringInput() {
        return scanner.nextLine();
    }
}
