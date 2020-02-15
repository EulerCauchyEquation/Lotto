package com.adaline.Lotto.domain;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * 등수 테스트
 *
 * @author 송훤출
 * @version 20.02.15
 */
public class RankTest {

    @Test
    public void 당첨_실패() {
        Assert.assertThat(Rank.MISS, is(Rank.valueOf(0, true)));
        Assert.assertThat(Rank.MISS, is(Rank.valueOf(0, false)));
        Assert.assertThat(Rank.MISS, is(Rank.valueOf(1, true)));
        Assert.assertThat(Rank.MISS, is(Rank.valueOf(1, false)));
        Assert.assertThat(Rank.MISS, is(Rank.valueOf(2, true)));
        Assert.assertThat(Rank.MISS, is(Rank.valueOf(2, false)));
    }

    @Test
    public void 당첨_오등() {
        Assert.assertThat(Rank.FIFTH, is(Rank.valueOf(3, true)));
        Assert.assertThat(Rank.FIFTH, is(Rank.valueOf(3, false)));
    }

    @Test
    public void 당첨_사등() {
        Assert.assertThat(Rank.FOURTH, is(Rank.valueOf(4, true)));
        Assert.assertThat(Rank.FOURTH, is(Rank.valueOf(4, false)));
    }

    @Test
    public void 당첨_삼등() {
        Assert.assertThat(Rank.THIRD, is(Rank.valueOf(5, false)));
    }

    @Test
    public void 당첨_이등() {
        Assert.assertThat(Rank.SECOND, is(Rank.valueOf(5, true)));
    }

    @Test
    public void 당첨_일등() {
        Assert.assertThat(Rank.FIRST, is(Rank.valueOf(6, true)));
        Assert.assertThat(Rank.FIRST, is(Rank.valueOf(6, false)));
    }

    @Test(expected = RuntimeException.class)
    public void 해당되지_않는_당첨수() {
        Rank.valueOf(7, false);
    }
}
