package com.adaline.Lotto.domain;

import java.util.List;

/**
 * 다량의 로또 클래스
 *
 * @author 송훤출
 * @version 1.0
 * @since 20.02.17
 */
public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public int totalCountOfLotto() {
        return lottoList.size();
    }

    public List<Lotto> getLottos() {
        return lottoList;
    }
}
