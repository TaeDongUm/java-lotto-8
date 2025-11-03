package lotto.controller;

import lotto.Lotto;
import lotto.constant.ErrorMessage;
import lotto.domain.*;
import lotto.parser.BonusNumberParser;
import lotto.parser.WinningNumbersParser;
import lotto.service.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoMachine = new LottoMachine();
    }

    public void start() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        List<Lotto> userLottos = purchaseLottos(purchaseAmount);
        WinningLotto winningLotto = getWinningLotto();
        calculateAndPrintResults(purchaseAmount, userLottos, winningLotto);
    }

    private PurchaseAmount getPurchaseAmount() {
        while (true) {
            try {
                String input = inputView.readPurchaseAmount();
                return new PurchaseAmount(Integer.parseInt(input));
            } catch (NumberFormatException e) {
                outputView.printErrorMessage(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Lotto> purchaseLottos(PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = lottoMachine.generate(purchaseAmount.calculateLottoCount());
        outputView.printLottoCount(purchaseAmount);
        outputView.printLottos(lottos);
        return lottos;
    }

    private WinningLotto getWinningLotto() {
        Lotto winningNumbers = getWinningNumbers();
        BonusNumber bonusNumber = getBonusNumber(winningNumbers);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private Lotto getWinningNumbers() {
        while (true) {
            try {
                String input = inputView.readWinningNumbers();
                List<Integer> numbers = WinningNumbersParser.parse(input);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private BonusNumber getBonusNumber(Lotto winningNumbers) {
        while (true) {
            try {
                String input = inputView.readBonusNumber();
                int number = BonusNumberParser.parse(input);
                BonusNumber bonusNumber = new BonusNumber(number);
                new WinningLotto(winningNumbers, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void calculateAndPrintResults(PurchaseAmount purchaseAmount, List<Lotto> userLottos,
            WinningLotto winningLotto) {
        List<LottoRank> ranks = userLottos.stream()
                .map(winningLotto::calculateRank)
                .collect(Collectors.toList());

        LottoResult lottoResult = new LottoResult(ranks);

        outputView.printResults(lottoResult);
        outputView.printProfitRate(lottoResult, purchaseAmount);
    }
}
