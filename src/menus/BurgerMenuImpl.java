package menus;

import menuItems.BurgerMenuItemImpl;
import menuItems.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BurgerMenuImpl implements Menu {
    private final List<MenuItem> burgerMenuItemList;
    private final String NAME = "Burgers";
    private boolean state = true;

    public BurgerMenuImpl() {
        this.burgerMenuItemList = new ArrayList<>();

        burgerMenuItemList.add(new BurgerMenuItemImpl(
                "ShackBurger",
                6.9,
                "토마토, 양상추, 쉑소스가 토핑된 치즈버거"
        ));
        burgerMenuItemList.add(new BurgerMenuItemImpl(
                "SmokeShack",
                8.9,
                "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"
        ));
        burgerMenuItemList.add(new BurgerMenuItemImpl(
                "Cheeseburger",
                6.9,
                "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"
        ));
        burgerMenuItemList.add(new BurgerMenuItemImpl(
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
    public String show() {
        StringBuilder result = new StringBuilder();

        // 스트림안에서 인덱스를 사용하기위해 AtomicInteger 사용
        AtomicInteger idx = new AtomicInteger(1);

        result.append("\n[ BURGERS MENU ]\n");
        burgerMenuItemList
                .forEach(item -> result.append(
                        String.format("%d. %-15s| W %.1f | %s\n",
                                idx.getAndIncrement(),
                                item.getName(),
                                item.getPrice(),
                                item.getDescription())
                ));
        result.append("0. 뒤로가기");

        return result.toString();
    }

    @Override
    public List<MenuItem> getList() {
        return burgerMenuItemList;
    }
}
