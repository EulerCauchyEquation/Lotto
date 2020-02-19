package com.adaline.Lotto;

import com.adaline.Lotto.Service.LottoService;
import com.adaline.Lotto.Service.MoneyService;
import com.adaline.Lotto.Service.WinningLottoService;
import com.adaline.Lotto.domain.*;
import com.adaline.Lotto.util.Printer;

/**
 * 메인 클래스
 *
 * @author 송훤출
 * @version 1.0
 * @since 20.02.18
 */
public class ConsoleMain {

    public static void main(String[] args) {
        MoneyService moneyService = new MoneyService();
        Money userMoney = moneyService.createMoney();

        LottoService lottoService = new LottoService();
        Lottos lottos = lottoService.buyLottos(userMoney);

        WinningLottoService winningLottoService = new WinningLottoService();
        WinningLotto winningLotto = winningLottoService.createWinningLotto();

        LottoResult result = winningLottoService.matchWinningLotto(lottos, winningLotto);
        long earnings = result.totalPrizeMoney();
        Profits profits = new Profits(userMoney, earnings);
        Printer.printProfits(profits);
    }
}
