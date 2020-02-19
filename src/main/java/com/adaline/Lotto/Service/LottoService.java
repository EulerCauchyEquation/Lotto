package com.adaline.Lotto.Service;

import com.adaline.Lotto.domain.Lotto;
import com.adaline.Lotto.domain.LottoNumber;
import com.adaline.Lotto.domain.Lottos;
import com.adaline.Lotto.domain.Money;

import java.util.*;

/**
 * Lotto에 생성과 복합적인 비즈니스 로직을 처리하는 클래스
 *
 * @author 송훤출
 * @version 1.0
 * @since 20.02.16
 */
public class LottoService {
    private static final int LOTTO_NUM_MIN = 1;
    private static final int LOTTO_NUM_MAX = 45;
    private static final int LOTTO_NUM_SIZE = 6;

    public Lottos buyLottos(Money money) {
        List<Lotto> lottoList = new ArrayList<>();
        while (lottoList.size() <= money.totalCountOfOneThousandWon()) {
            lottoList.add(createLotto());
        }
        return new Lottos(lottoList);
    }

    private Lotto createLotto() {
        return new Lotto(createNonDuplicate());
    }

    private List<LottoNumber> createNonDuplicate() {
        Set<LottoNumber> nonDuplicateLotto = new HashSet<>();

        while (nonDuplicateLotto.size() < LOTTO_NUM_SIZE) {
            nonDuplicateLotto.add(createNumber());
        }
        List<LottoNumber> sortedLotto = new ArrayList<>(nonDuplicateLotto);
        Collections.sort(sortedLotto);
        return sortedLotto;
    }

    private LottoNumber createNumber() {
        Random random = new Random();
        int number = random.nextInt(LOTTO_NUM_MAX - LOTTO_NUM_MIN + 1) +
                LOTTO_NUM_MIN;
        return new LottoNumber(number);
    }
}
