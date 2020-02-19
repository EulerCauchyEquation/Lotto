package com.adaline.Lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 로또 티켓
 *
 * @author 송훤출
 * @version 1.0
 * @since 2020.02.15
 */
public class Lotto {
    private static final int LOTTO_NUM_SIZE = 6;

    private final List<LottoNumber> lottoTicket;

    public Lotto(List<LottoNumber> lottoTicket) {
        validateLottoSize(lottoTicket);
        validateDuplicate(lottoTicket);
        this.lottoTicket = lottoTicket;
    }

    private void validateLottoSize(List<LottoNumber> lottoTicket) {
        if (lottoTicket.size() != LOTTO_NUM_SIZE) {
            throw new RuntimeException("로또 번호는 총 6개이어야 합니다.");
        }
    }

    private void validateDuplicate(List<LottoNumber> lottoTicket) {
        Set<LottoNumber> nonDuplicateLottoTicket = new HashSet<>(lottoTicket);
        if (nonDuplicateLottoTicket.size() < LOTTO_NUM_SIZE) {
            throw new RuntimeException("로또티켓의 번호가 중복이 되면 안 됩니다.");
        }
    }

    public boolean contains(LottoNumber number) {
        return lottoTicket.contains(number);
    }

    public int match(Lotto userLotto) {
        return (int) lottoTicket.stream()
                .filter(userLotto::contains)
                .count();
    }
}
