package menu;

import menuItem.BeverageMenuItemImpl;
import menuItem.MenuItem;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BeverageMenuImpl implements Menu {

    private final List<MenuItem> beverageMenuItemList;
    private final String TITLE = "DRINKS MENU";

    /**
     * 객체 생성 동시에 메뉴 삽입
     */
    public BeverageMenuImpl() {
        this.beverageMenuItemList = new ArrayList<>();

        beverageMenuItemList.add(
                new BeverageMenuItemImpl(
                        "Coca-cola",
                        1,
                        "시원한 코카콜라"
                ));
        beverageMenuItemList.add(
                new BeverageMenuItemImpl(
                        "Sprite",
                        1,
                        "청량한 스프라이트"
                ));
    }

    @Override
    public String getTitle() {
        return this.TITLE;
    }

    @Override
    public List<MenuItem> getList() {
        return beverageMenuItemList;
    }
}
