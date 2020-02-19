package com.adaline.Lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> result = new HashMap<>();

    {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public LottoResult(List<Rank> winningList) {
        for (Rank rank : winningList) {
            result.put(rank, result.get(rank) + 1);
        }
    }

    public Long totalPrizeMoney() {
        long sum = 0;
        for (Rank rank : result.keySet()) {
            int count = result.get(rank);
            sum += rank.getWinningMoney() * count;
        }
        return sum;
    }
}
