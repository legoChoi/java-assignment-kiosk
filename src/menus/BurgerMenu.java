package menus;

import menuItems.BurgerMenuItem;
import menuItems.MenuItem;
import shared.io.output.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BurgerMenu implements Menu {
    private final List<MenuItem> burgerMenuItemList;
    private final Output consoleOutput;
    private final String NAME = "Burgers";
    private boolean state = true;

    public BurgerMenu(Output consoleOutput) {
        this.burgerMenuItemList = new ArrayList<>();
        this.consoleOutput = consoleOutput;

        burgerMenuItemList.add(new BurgerMenuItem(
                "ShackBurger",
                6.9,
                "토마토, 양상추, 쉑소스가 토핑된 치즈버거"
        ));
        burgerMenuItemList.add(new BurgerMenuItem(
                "SmokeShack",
                8.9,
                "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"
        ));
        burgerMenuItemList.add(new BurgerMenuItem(
                "cheeseburger",
                6.9,
                "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"
        ));
        burgerMenuItemList.add(new BurgerMenuItem(
                "Hamburger",
                5.4,
                "비프패티를 기반으로 야채가 들어간 기본버거"
        ));
    }

    @Override
    public boolean getState() {
        return state;
    }

    @Override
    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public void show() {
        // 스트림안에서 인덱스를 사용하기위해 AtomicInteger 사용
        AtomicInteger idx = new AtomicInteger(1);

        consoleOutput.print("\n[ BURGER MENU ]");
        burgerMenuItemList
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
        return burgerMenuItemList;
    }
}
