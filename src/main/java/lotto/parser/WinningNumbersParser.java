package lotto.parser;

import java.util.Arrays;
import java.util.List;

public class WinningNumbersParser {

    private static final String DELIMITER = ",";

    public static List<Integer> parse(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 입력해 주세요.");
        }
        String[] tokens = input.split(DELIMITER, -1);
        if (Arrays.stream(tokens).anyMatch(String::isBlank)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 빈 값은 허용되지 않습니다.");
        }
        try {
            return Arrays.stream(tokens)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력 가능합니다.", e);
        }
    }
}
