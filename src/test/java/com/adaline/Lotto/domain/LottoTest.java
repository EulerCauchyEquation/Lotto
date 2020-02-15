package com.adaline.Lotto.domain;

import org.junit.Test;

import java.util.Arrays;

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

}
