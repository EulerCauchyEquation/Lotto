package com.adaline.Lotto.Service;

import com.adaline.Lotto.domain.Lottos;
import com.adaline.Lotto.domain.Money;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * LottoService 테스트
 *
 * @author 송훤출
 * @version 1.0
 * @since 20.02.16
 */
public class LottoServiceTest {
    private static final int NUMBER_CYCLE = 1000;

    private LottoService service;

    @Before
    public void setup() {
        service = new LottoService();
    }

    @Test
    public void 로또_여러장_생성_테스트() {
        Money money = new Money(8000);

        for (int i = 0; i < NUMBER_CYCLE; i++) {
            try {
                Lottos lottos = service.buyLottos(money);
            } catch (Exception e) {
                Assert.fail(e.getMessage());
            }
        }
    }
}
