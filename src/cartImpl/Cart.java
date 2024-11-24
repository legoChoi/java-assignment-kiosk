package cartImpl;

import menuItem.MenuItem;

import java.util.List;

public interface Cart {
    /** 장바구니 내 상품 금액의 총합
     * getter
     * @return sumPrice 장바구니 내 상품의 총 금액
     */
    double getSumPrice();

    /**
     * 삭제 시에 호출되는 메소드.
     * 인자로 들어오는 리스트로 바꾼다.
     * @param cartList 새로 넣을 리스트
     */
    void setCartList(List<MenuItem> cartList);

    /**
     * 장바구니에 메뉴를 추가하는 메소드.
     * @param menuItem 장바구니에 추가 할 MenuItem 객체
     */
    void addToCart(MenuItem menuItem);

    /**
     * 장바구니에 동일한 메뉴가 있을 수 있으므로 주소값 비교하여 삭제
     * @param menuItem 삭제 할 메뉴
     */
    void removeFromCart(MenuItem menuItem);

    /**
     * 주문 시 호출되는 장바구니 초기화
     */
    void initCartList();


    /**
     * 장바구니 리스트 조회
     * @return 장바구니 리스트
     */
    List<MenuItem> getCartList();
}
