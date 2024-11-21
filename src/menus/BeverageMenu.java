package menus;

import menuItems.BeverageMenuItem;
import menuItems.MenuItem;
import shared.io.output.Output;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BeverageMenu implements Menu {
    private final List<MenuItem> beverageMenuItemList;
    private final Output consoleOutput;
    private boolean state = true;

    public BeverageMenu(Output consoleOutput) {
        this.consoleOutput = consoleOutput;
        this.beverageMenuItemList = new ArrayList<>();

        beverageMenuItemList.add(
                new BeverageMenuItem(
                        "coca-cola",
                        1,
                        "시원한 코카콜라"
                ));
        beverageMenuItemList.add(
                new BeverageMenuItem(
                        "sprite",
                        1,
                        "청량한 스프라이트"
                ));
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public void show() {
        // 스트림안에서 인덱스를 사용하기위해 AtomicInteger 사용
        AtomicInteger idx = new AtomicInteger(1);

        System.out.println("\n[ BEVERAGE MENU ]");
        beverageMenuItemList
                .forEach(item -> consoleOutput.print(
                        String.format("%d. %-15s| W %.1f | %s",
                                idx.getAndIncrement(),
                                item.getName(),
                                item.getPrice(),
                                item.getDescription())
                ));
        consoleOutput.print("0. 뒤로가기");
    }

    @Override
    public List<MenuItem> getList() {
        return beverageMenuItemList;
    }
}
