package com.adaline.Lotto.Service;

import com.adaline.Lotto.domain.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

public class WinningLottoServiceTest {

    @Test
    public void 요청된_로또들_당첨결과_확인() {
        // given
        WinningLottoService service = new WinningLottoService();

        // when
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        )));
        lottoList.add(new Lotto(Arrays.asList(
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(7),
                new LottoNumber(8)
        )));
        Lottos lottos = new Lottos(lottoList);
        Lotto lotto = new Lotto(Arrays.asList(
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(7),
                new LottoNumber(40),
                new LottoNumber(41)
        ));
        LottoNumber bonus = new LottoNumber(42);
        WinningLotto winningLotto = new WinningLotto(lotto, bonus);
        LottoResult lottoResult = service.matchWinningLotto(lottos, winningLotto);

        // then
        Assert.assertThat(55_000L, equalTo(lottoResult.totalPrizeMoney()));
    }
}
