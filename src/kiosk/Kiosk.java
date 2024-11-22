package kiosk;

import menuItems.MenuItem;
import menus.Menu;
import shared.exceptions.exceptionMessages.ExceptionMessages;
import shared.exceptions.exceptions.NotValidInputException;
import shared.io.input.Input;
import shared.io.output.Output;

import java.util.List;

public class Kiosk {
    private final Menu burgerMenu;
    private final Menu beverageMenu;
    private boolean state = true;
    private final Input consoleInput;
    private final Output consoleOutput;

    public Kiosk(Input consoleInput, Output consoleOutput, Menu burgerMenu, Menu beverageMenu) {
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;
        this.burgerMenu = burgerMenu;
        this.beverageMenu = beverageMenu;

        start();
    }

    /**
     *
     * @return 현재 인스턴스의 state 값
     */
    private boolean getState() {
        return state;
    }

    /**
     *
     * @param state 변환할 state 값
     */
    private void setState(boolean state) {
        this.state = state;
    }

    private void start() {
        while (getState()) {
            showMainMenu();
            int commandInput;

            try {
                commandInput = consoleInput.getIntInput();

                if (commandInput == 0) {
                    setState(false);
                    continue;
                }
                if (commandInput < 0 || commandInput > 3) {
                    consoleOutput.print(ExceptionMessages.NotValidMenuInput.getMessage());
                    continue;
                }

                if (commandInput == 1) showMenu(burgerMenu);
                if (commandInput == 2) showMenu(beverageMenu);

            } catch (NotValidInputException e) {
                consoleOutput.print(e.getMessage());
                consoleInput.getStringInput(); // 개행 문자 처리
            }
        }
    }

    /** 메인 메뉴 보여주는 메소드 **/
    private void showMainMenu() {
        String title = "\n[ MAIN MENU ]\n" +
                "1. Burgers\n" +
                "2. Drinks\n" +
                "3. Desserts\n" +
                String.format("%-13s | %s", "0. 종료", "종료");

        consoleOutput.print(title);
    }

    /**
     * Menu 구현체의 메뉴 리스트를 보여주는 메소드
     * @param menu Menu 구현체
     */
    private void showMenu(Menu menu) {
        int commandInput;
        List<MenuItem> menuItemList = menu.getList();
        MenuItem menuItem;

        while (menu.getState()) {
            consoleOutput.print(menu.show());
            try {
                commandInput = consoleInput.getIntInput();

                if (commandInput == 0) {
                    menu.setState(false);
                    continue;
                }
                if (commandInput < 0 || commandInput > menuItemList.size()) {
                    consoleOutput.print(ExceptionMessages.NotValidMenuInput.getMessage());
                    continue;
                }

                menuItem = menuItemList.get(commandInput - 1);

                consoleOutput.print(String.format(
                        "선택한 메뉴: %s | W %.1f | %s",
                        menuItem.getName(),
                        menuItem.getPrice(),
                        menuItem.getDescription()
                ));

                menu.setState(false);
            } catch (NotValidInputException e) {
                consoleOutput.print(e.getMessage());
                consoleInput.getStringInput(); // 개행 문자 처리
            }
        }

        menu.setState(true);
    }
}
