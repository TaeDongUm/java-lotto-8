package lotto.constant;

public enum Message {
    PROMPT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PROMPT_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    PROMPT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),

    INFO_PURCHASE_COUNT("\n%d개를 구매했습니다.\n"),

    RESULT_HEADER("\n당첨 통계"),
    RESULT_SEPARATOR("---"),
    RESULT_PROFIT_RATE("총 수익률은 %.1f%%입니다.\n"),

    // 포맷: 일치개수, 보너스문구, 상금, 개수
    RESULT_RANK_FORMAT("%d개 일치%s (%,d원) - %d개"),
    BONUS_MATCH_TEXT(", 보너스 볼 일치");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
