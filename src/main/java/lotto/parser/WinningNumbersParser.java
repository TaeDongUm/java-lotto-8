package lotto.parser;

import lotto.constant.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class WinningNumbersParser {

    private static final String DELIMITER = ",";

    public static List<Integer> parse(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_EMPTY.getMessage());
        }
        String[] tokens = input.split(DELIMITER, -1);
        if (Arrays.stream(tokens).anyMatch(String::isBlank)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_CONTAINS_EMPTY_TOKEN.getMessage());
        }
        try {
            return Arrays.stream(tokens)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage(), e);
        }
    }
}
