package menu;

import menuItem.BurgerMenuItemImpl;
import menuItem.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class BurgerMenuImpl implements Menu {

    private final List<MenuItem> burgerMenuItemList;
    private final String TITLE = "BURGERS MENU";

    /**
     * 객체 생성 동시에 메뉴 삽입
     */
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
    public String getTitle() {
        return this.TITLE;
    }

    @Override
    public List<MenuItem> getList() {
        return burgerMenuItemList;
    }
}
