package cartImpl;

import menuItem.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class CartImpl implements Cart {

    private final List<MenuItem> cartList;
    private double sumPrice = 0;

    /**
     * 생성자
     */
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

    /**
     * 삭제 시에 호출되는 메소드.
     * 인자로 들어오는 리스트로 바꾼다.
     * @param cartList 새로 넣을 리스트
     */
    @Override
    public void setCartList(List<MenuItem> cartList) {
        this.cartList.clear();
        this.cartList.addAll(cartList);
    }

    /**
     * 장바구니에 메뉴를 추가하는 메소드.
     * @param menuItem 장바구니에 추가 할 MenuItem 객체
     */
    @Override
    public void addToCart(MenuItem menuItem) {
        this.cartList.add(menuItem);
        setSumPrice(menuItem.price());
    }

    /**
     *
     * @param menuItem
     */
    @Override
    public void removeFromCart(MenuItem menuItem) {
        setSumPrice(-menuItem.price());

        // 스트림을 활용한 객체 제거
        setCartList(this.cartList.stream()
                .filter(item -> item != menuItem)
                .toList());
    }

    @Override
    public void initCartList() {
        this.cartList.clear();
        this.sumPrice = 0;
    }

    @Override
    public List<MenuItem> getCartList() {
        return this.cartList;
    }
}
