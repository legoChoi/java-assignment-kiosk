package shared.exceptions.exceptionMessages;

public enum ExceptionMessages {
    NOT_VALID_MENU_INPUT("유효하지 않은 입력입니다."),
    CART_EMPTY("장바구니가 비었습니다."),
    ORDER_LIST_EMPTY("주문 목록이 비었습니다.");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
