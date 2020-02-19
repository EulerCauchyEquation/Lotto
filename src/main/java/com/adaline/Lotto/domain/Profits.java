package com.adaline.Lotto.domain;

/**
 * 이익률 클래스
 *
 * @author 송훤출
 * @version 1.0
 * @since 20.02.16
 */
public class Profits {
    private final Money money;
    private final long earnings;

    public Profits(Money money, long earnings) {
        if (earnings < 0) {
            throw new RuntimeException("이익 액수가 마이너스일 수는 없습니다.");
        }
        this.money = money;
        this.earnings = earnings;
    }

    public double calculateEarningRate() {
        double earningRate = earnings / Double.parseDouble(money.toString());
        return format(earningRate);
    }

    private double format(double earningRate) {
        return (Math.round(earningRate * 1000)) / 1000.0;
    }
}
