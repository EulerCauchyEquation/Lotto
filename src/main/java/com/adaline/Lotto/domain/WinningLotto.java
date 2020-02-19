package com.adaline.Lotto.domain;

/**
 * 당첨번호 관리 클래스
 *
 * @author 송훤출
 * @version 1.0
 * @since 20.02.15
 */
public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNo;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNo) {
        validateDuplicateBonusNo(winningLotto, bonusNo);
        this.winningLotto = winningLotto;
        this.bonusNo = bonusNo;
    }

    private void validateDuplicateBonusNo(Lotto winningLotto, LottoNumber bonusNo) {
        if (winningLotto.contains(bonusNo)) {
            throw new RuntimeException("보너스 볼은 당첨번호들과 중복되면 안 됩니다.");
        }
    }

    public Rank match(Lotto userLotto) {
        int matchCount = winningLotto.match(userLotto);
        boolean bonus = userLotto.contains(bonusNo);
        return Rank.valueOf(matchCount, bonus);
    }
}
