package shared.exceptions.exceptionMessages;

public enum ExceptionMessages {
    NotValidMenuInput("유효하지 않은 입력입니다.");

    private final String errorMessage;

    ExceptionMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return this.errorMessage;
    }
}
