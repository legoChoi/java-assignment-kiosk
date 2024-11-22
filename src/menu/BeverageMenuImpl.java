package menu;

import menuItem.BeverageMenuItemImpl;
import menuItem.MenuItem;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BeverageMenuImpl implements Menu {
    private final List<MenuItem> beverageMenuItemList;
    private boolean state = true;

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

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String show() {
        StringBuilder result = new StringBuilder();

        // 스트림안에서 인덱스를 사용하기위해 AtomicInteger 사용
        AtomicInteger idx = new AtomicInteger(1);

        result.append("\n[ DRINKS MENU ]\n");
        beverageMenuItemList
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
        return beverageMenuItemList;
    }
}
