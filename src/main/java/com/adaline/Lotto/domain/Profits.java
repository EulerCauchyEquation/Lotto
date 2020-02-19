package com.adaline.Lotto.domain;

/**
 * 이익률 클래스
 *
 * @author 송훤출
 * @version 1.0
 * @since 20.02.16
 */
public class Profits {
    private static final int MIN_EARNINGS = 0;
    private static final int MIN_FORMAT = 3;

    private final Money money;
    private final long earnings;

    public Profits(Money money, long earnings) {
        validateMinEarnings(earnings);
        this.money = money;
        this.earnings = earnings;
    }

    private void validateMinEarnings(long earnings) {
        if (earnings < MIN_EARNINGS) {
            throw new RuntimeException("이익 액수가 마이너스일 수는 없습니다.");
        }
    }

    public double calculateEarningRate() {
        double earningRate = earnings / Double.parseDouble(money.toString());
        return format(earningRate);
    }

    private double format(double earningRate) {
        return Double.parseDouble(
                String.format("%10." + MIN_FORMAT + "f"
                        , earningRate));
    }
}
