package com.adaline.Lotto.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;

/**
 * 로또 티켓 유효 테스트
 *
 * @author 송훤출
 * @version 1.0
 * @since 2020.02.15
 */
public class LottoTest {

    @Test(expected = RuntimeException.class)
    public void 로또티켓_로또번호_개수_맞지_않을_때() {
        new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5)
        ));
    }

    @Test(expected = RuntimeException.class)
    public void 로또티켓_번호_중첩이_있을_때() {
        new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(5)
        ));
    }

    @Test
    public void 제시된_번호와_같은번호가_있을때() {
        Lotto lotto = new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
        LottoNumber number = new LottoNumber(3);
        Assert.assertThat(true, is(lotto.contains(number)));
    }

    @Test
    public void 제시된_번호와_같은번호가_없을때() {
        Lotto lotto = new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
        LottoNumber number = new LottoNumber(7);
        Assert.assertThat(false, is(lotto.contains(number)));
    }

    @Test
    public void 다른로또와_번호_비교해서_동일한_숫자_카운팅() {
        Lotto lotto = new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
        Lotto otherLotto = new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(7),
                new LottoNumber(3),
                new LottoNumber(8),
                new LottoNumber(5),
                new LottoNumber(9)
        ));
        Assert.assertThat(3, is(lotto.match(otherLotto)));
    }
}
