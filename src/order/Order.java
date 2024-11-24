package order;

import menuItem.MenuItem;

import java.util.List;

public interface Order {
    /**
     * 장바구니에 등록된 메뉴 리스트를 주문 리스트로 옮김
     * @param menuList 장바구니 메뉴 리스트
     * @param originalPrice 할인 전 가격
     * @param ratio 할인율
     * @return 할인 적용된 가격
     */
    double addCartToOrderList(List<MenuItem> menuList, double originalPrice, int ratio);

    /**
     * 주문 리스트 조회
     * @return 주문 리스트
     */
    List<List<MenuItem>> getOrderList();

    /**
     * 주문 리스트 내 주문 내역에 맞는 가격 리스트 좋회
     * @return 주문 가격 리스트
     */
    List<Double> getPriceList();

    /**
     * 주문 리스트 길이 조회
     * @return 주문 리스트 길이
     */
    int getOrderListSize();

    /**
     * 인덱스에 해당하는 주문 내역 삭제
     * 가격 리스트에서도 삭제
     */
    void remove(int idx);
}
