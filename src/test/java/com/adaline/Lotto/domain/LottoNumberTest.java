package com.adaline.Lotto.domain;

import org.junit.Test;

/**
 * 로또번호 객체 test
 *
 * @author 송훤출
 * @version 1.0
 * @since 20.02.14
 */
public class LottoNumberTest {

    @Test(expected = RuntimeException.class)
    public void 로또번호가_범위에서_벗어날_때() {
        new LottoNumber(46);
    }
}
