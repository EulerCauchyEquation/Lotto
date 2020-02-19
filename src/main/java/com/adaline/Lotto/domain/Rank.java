package com.adaline.Lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final int WIN_MIN = 3;

    private int countOfMatch;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean bonus) {
        if (countOfMatch < WIN_MIN) {
            return Rank.MISS;
        }
        if (SECOND.match(countOfMatch)
                && bonus) {
            return Rank.SECOND;
        }
        for (Rank rank : values()) {
            if ((rank.match(countOfMatch))
                    && (rank != SECOND)) {
                return rank;
            }
        }
        throw new RuntimeException(countOfMatch + " 는 해당되는 등수가 없습니다.");
    }

    private boolean match(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
