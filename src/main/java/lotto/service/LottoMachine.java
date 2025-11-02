package lotto.service;

import lotto.Lotto;

import java.util.List;

public class LottoMachine {

    public List<Lotto> generate(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("[ERROR] 로또 발행 장수는 1장 이상이어야 합니다.");
        }

        return null;
    }
}
