package com.adaline.Lotto.domain;

import java.util.List;

public class LottoResult {
    private final List<Rank> winningList;

    public LottoResult(List<Rank> winningList) {
        this.winningList = winningList;
    }

    public long totalPrizeMoney() {
        return winningList.stream()
                .mapToLong(Rank::getWinningMoney)
                .sum();
    }
}
