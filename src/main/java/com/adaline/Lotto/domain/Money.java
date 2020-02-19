package com.adaline.Lotto.domain;

/**
 * 돈 객체
 *
 * @author 송훤출
 * @version 1.0
 * @since 20.02.16
 */
public class Money {
    private static final int ONE_THOUSAND_WON = 1000;
    private static final int MIN_MONEY = 0;

    private final long money;

    public Money(long money) {
        if (money < MIN_MONEY) {
            throw new RuntimeException("돈은 음수가 될 수 없습니다.");
        }
        if (money < ONE_THOUSAND_WON) {
            throw new RuntimeException("구입금액이 부족합니다.");
        }
        this.money = money;
    }

    public long totalCountOfOneThousandWon() {
        return (int) (money / ONE_THOUSAND_WON);
    }

    @Override
    public String toString() {
        return String.valueOf(money);
    }
}
