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

    private final long money;

    public Money(long money) {
        validateMinimumMoney(money);
        this.money = money;
    }

    private void validateMinimumMoney(long money) {
        if (money < ONE_THOUSAND_WON) {
            throw new RuntimeException("구입금액이 부족합니다.");
        }
    }

    public int totalCountOfOneThousandWon() {
        return (int) (money / ONE_THOUSAND_WON);
    }

    @Override
    public String toString() {
        return String.valueOf(money);
    }
}
