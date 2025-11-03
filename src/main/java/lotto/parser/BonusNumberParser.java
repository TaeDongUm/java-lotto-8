package lotto.parser;

import lotto.constant.ErrorMessage;

public class BonusNumberParser {

    public static int parse(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_EMPTY.getMessage());
        }
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage(), e);
        }
    }
}
