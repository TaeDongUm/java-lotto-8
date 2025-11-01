package lotto.parser;

public class NumberParser {

    public static int parse(String input) {
        if (input.isBlank() || input == null) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
        }

        return 0; // 임시 반환
    }
}
