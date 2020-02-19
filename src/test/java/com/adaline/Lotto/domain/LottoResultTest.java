package com.adaline.Lotto.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;

public class LottoResultTest {

    @Test
    public void 총_당청금() {
        LottoResult result = new LottoResult(Arrays.asList(
                Rank.FIRST, Rank.THIRD, Rank.FOURTH, Rank.THIRD
        ));
        Assert.assertThat(2_003_050_000L, is(result.totalPrizeMoney()));
    }
}
