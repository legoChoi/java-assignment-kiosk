package shared.exceptions.exceptions;

import shared.exceptions.exceptionMessages.ExceptionMessages;

public class OrderListEmptyException extends RuntimeException {
    public OrderListEmptyException() {
        super(ExceptionMessages.ORDER_LIST_EMPTY.getMessage());
    }
}
