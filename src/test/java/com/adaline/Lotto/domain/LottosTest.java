package com.adaline.Lotto.domain;

import com.adaline.Lotto.Service.LottoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * 다량의 로또 클래스 테스트
 *
 * @author 송훤출
 * @version 1.0
 * @since 20.02.17
 */
public class LottosTest {
    private LottoService service;
    private Lottos lottos;

    @Before
    public void setup() {
        service = new LottoService();
        lottos = service.buyLottos(new Money(8500));
    }

    @Test
    public void 로또복권수_확인() {
        Lottos lottos = service.buyLottos(new Money(8500));
        Assert.assertThat(8, is(lottos.totalCountOfLotto()));
    }
}
