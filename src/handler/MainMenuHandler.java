package handler;

import shared.exceptions.exceptions.NotValidInputException;
import shared.io.input.Input;
import shared.io.output.Output;

public class MainMenuHandler {

    private final Input consoleInput;
    private final Output consoleOutput;


    public MainMenuHandler(Input consoleInput, Output consoleOutput) {
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;
    }

    public int showMenu() {
        int response = -1;

        consoleOutput.print(buildView());

        try {
            response = consoleInput.getIntInput();

            return response;
        } catch (NotValidInputException e) {
            consoleOutput.print(e.getMessage());
            consoleInput.getStringInput();
        }

        return response;
    }

    private String buildView() {
        StringBuilder view = new StringBuilder();

        String mainMenu = "\n[ MAIN MENU ]\n" +
                "1. Burgers\n" +
                "2. Drinks\n" +
                "3. Desserts\n" +
                String.format("0. %-13s | %s", "종료", "종료");

        String orderMenu = "\n\n[ ORDER MENU ]\n" +
                String.format("4. %-13s | %s\n", "Orders", "장바구니를 확인 후 주문합니다.") +
                String.format("5. %-13s | %s", "Cancel", "진행중인 주문을 취소합니다.");

        view.append(mainMenu);
        view.append(orderMenu);

        return view.toString();
    }
}
