package lotto.constant;

public enum ErrorMessage {
    AMOUNT_NOT_DIVISIBLE("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),
    AMOUNT_NOT_POSITIVE("[ERROR] 구입 금액은 양수여야 합니다."),
    INVALID_NUMBER_FORMAT("[ERROR] 유효한 숫자 형식이 아닙니다."),

    LOTTO_INVALID_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_DUPLICATE_NUMBERS("[ERROR] 로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),

    INPUT_EMPTY("[ERROR] 입력값이 비어있습니다."),
    INPUT_CONTAINS_EMPTY_TOKEN("[ERROR] 입력값에 빈 토큰이 포함되어 있습니다."),

    BONUS_DUPLICATE_WITH_WINNING_NUMBERS("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),

    ISSUE_COUNT_NOT_POSITIVE("[ERROR] 로또 발행 장수는 1장 이상이어야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
