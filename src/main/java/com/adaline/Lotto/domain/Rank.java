package com.adaline.Lotto.domain;

public enum Rank {
    FIRST(6),
    SECOND(5),
    THIRD(5),
    FOURTH(4),
    FIFTH(3),
    MISS(0);

    private static final int WIN_MIN = 3;

    private int countOfMatch;

    Rank(int countOfMatch) {
        this.countOfMatch = countOfMatch;
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
}
