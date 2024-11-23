package cartImpl;

import menuItem.MenuItem;
import shared.exceptions.exceptions.CartEmptyException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CartImpl implements Cart {

    private final List<MenuItem> cartList;
    private boolean state = true;
    private double sumPrice = 0;

    public CartImpl() {
        this.cartList = new ArrayList<>();
    }

    /** 장바구니 내 상품 금액의 총합
     * getter
     * @return sumPrice 장바구니 내 상품의 총 금액
     */
    @Override
    public double getSumPrice() {
        return sumPrice;
    }

    /**
     * setter 장바구니 내 상품 금액의 총합에 새로 등록되는 상품의 금액 추가
     * @param sumPrice 장바구니에 추가되는 상품
     */
    private void setSumPrice(double sumPrice) {
        this.sumPrice += sumPrice;
    }

    @Override
    public void addToCart(MenuItem menuItem) {
        this.cartList.add(menuItem);
        setSumPrice(menuItem.getPrice());
    }

    @Override
    public void removeFromCart(MenuItem menuItem) {
        setSumPrice(-menuItem.getPrice());

        // 스트림을 활용한 객체 제거
        this.cartList.stream()
                .filter(item -> item.equals(menuItem))
                .toList()
                .forEach(this.cartList::remove);
    }

    @Override
    public void clearCartList() {
        this.cartList.clear();
        this.sumPrice = 0;
    }

    @Override
    public List<MenuItem> getCartList() {
        return this.cartList;
    }

    @Override
    public String show() {
        StringBuilder result = new StringBuilder();

        // 스트림안에서 인덱스를 사용하기위해 AtomicInteger 사용
        AtomicInteger idx = new AtomicInteger(1);

        result.append("\n[ ORDER MENU ]\n");

        if (cartList.isEmpty()) {
            throw new CartEmptyException();
        }

        this.cartList.forEach(item -> {
            result.append(String.format(
                    "%d. %-15s| W %.1f | %s\n",
                    idx.getAndIncrement(),
                    item.getName(),
                    item.getPrice(),
                    item.getDescription()));
        });

        result.append("\n[ Total ]\n");
        result.append(String.format("W %.1f\n", getSumPrice()));

        result.append(String.format(
                "\n1. %-10s 2. %-10s 3. %s",
                "주문",
                "삭제",
                "메뉴판"
        ));

        return result.toString();
    }


    @Override
    public void addMenuToCart(MenuItem menu) {
        System.out.println("\n\"" + menu.toString() + "\"");
        System.out.println(addView());

//        cartList.add(menu);
    }

    private String addView() {

//        while (true) {

        String view = "위 메뉴를 장바구니에 추가하시겠습니까?\n" +
                String.format(
                        "1. %-10s 2. %s",
                        "확인", "취소"
                );

//            commandInput = validateCommandInput();
//
//            if (commandInput == 1) {
//                cart.addToCart(menuItem);
//                consoleOutput.print(menuItem.getName() + "이 장바구니에 추가되었습니다.");
//                break;
//            }
//            else if (commandInput == 2) {
//                break;
//            } else {
//                consoleOutput.print(ExceptionMessages.NOT_VALID_MENU_INPUT.getMessage());
//            }
//        }

        return view;
    }
}
