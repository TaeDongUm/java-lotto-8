package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Message;

public class InputView {

    public String readPurchaseAmount() {
        System.out.println(Message.PROMPT_PURCHASE_AMOUNT.getMessage());
        return Console.readLine();
    }

    public String readWinningNumbers() {
        System.out.println(Message.PROMPT_WINNING_NUMBERS.getMessage());
        return Console.readLine();
    }

    public String readBonusNumber() {
        System.out.println(Message.PROMPT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
