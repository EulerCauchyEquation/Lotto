package com.adaline.Lotto.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;

/**
 * 당첨번호 테스트
 *
 * @author 송훤출
 * @version 1.0
 * @since 20.02.15
 */
public class WinningLottoTest {
    private WinningLotto winningLotto;

    @Before
    public void init() {
        Lotto lotto = new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
        LottoNumber bonus = new LottoNumber(7);
        winningLotto = new WinningLotto(lotto, bonus);
    }

    @Test(expected = RuntimeException.class)
    public void 당첨번호와_보너스볼_중복일_떄() {
        Lotto lotto = new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
        LottoNumber bonus = new LottoNumber(6);
        new WinningLotto(lotto, bonus);
    }

    @Test
    public void 당첨번호_1개_일치() {
        Lotto userLotto = new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
        Assert.assertThat(Rank.MISS, is(winningLotto.match(userLotto)));
    }

    @Test
    public void 당첨번호_2개_일치() {
        Lotto userLotto = new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
        Assert.assertThat(Rank.MISS, is(winningLotto.match(userLotto)));
    }
}
