package com.adaline.Lotto.domain;

import java.util.Objects;

/**
 * 로또번호 객체
 *
 * @author 송훤출
 * @version 1.0
 * @since 20.02.14
 */
public class LottoNumber implements Comparable<LottoNumber> {
    private static final int LOTTO_NUM_MIN = 1;
    private static final int LOTTO_NUM_MAX = 45;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (lottoNumber < LOTTO_NUM_MIN || lottoNumber > LOTTO_NUM_MAX) {
            throw new RuntimeException("로또 번호가 범위에서 벗어납니다.");
        }
        this.lottoNumber = lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return true;
        }
        LottoNumber other = (LottoNumber) obj;
        return lottoNumber == other.lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return lottoNumber - other.lottoNumber;
    }
}
