package lotto.parser;

import java.util.List;

public class WinningNumbersParser {

    public static List<Integer> parse(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 입력해 주세요.");
        }

        return null;
    }
}
