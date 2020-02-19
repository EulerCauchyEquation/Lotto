package com.adaline.Lotto.domain;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * 돈 객체 테스트
 *
 * @author 송훤출
 * @version 1.0
 * @since 20.02.16
 */
public class MoneyTest {

    @Test(expected = RuntimeException.class)
    public void 돈_로또한장_가격_이하() {
        new Money(900);
    }

    @Test
    public void 천원짜리_수_출력() {
        Money money = new Money(7500);
        Assert.assertThat(7,
                is(money.totalCountOfOneThousandWon()));
    }
}
