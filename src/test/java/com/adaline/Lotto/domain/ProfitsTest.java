package com.adaline.Lotto.domain;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * 이익률 클래스 테스트
 *
 * @author 송훤출
 * @version 1.0
 * @since 20.02.17
 */
public class ProfitsTest {

    @Test
    public void 수익률_출력() {
        Money money = new Money(7700);
        Profits profits = new Profits(money, 5000);
        Assert.assertThat(0.649, is(profits.calculateEarningRate()));
    }

    @Test(expected = RuntimeException.class)
    public void 수익금_마이너스_경우() {
        Money money = new Money(8000);
        new Profits(money, -10);
    }
}
