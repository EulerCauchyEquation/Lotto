package com.adaline.Lotto.Service;

import com.adaline.Lotto.domain.*;

import java.util.*;
import java.util.regex.Pattern;

/**
 * 당첨지 서비스 클래스
 *
 * @author 송훤출
 * @version 1.0
 * @since 20.02.18
 */
public class WinningLottoService {
    private static final String REGEX = "^[-]?[0-9]+";
    private static final String SPLIT_REGEX = ",";
    private static final int LOTTO_NUM_MIN = 1;
    private static final int LOTTO_NUM_MAX = 45;
    private static final int LOTTO_NUM_SIZE = 6;
    private Scanner scanner = new Scanner(System.in);

    public WinningLotto createWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력하세요.");
        Lotto winningLotto = createLotto();

        System.out.println("보너스 번호를 입력하세요.");
        LottoNumber bonus = createBonusNo(winningLotto);
        return new WinningLotto(winningLotto, bonus);
    }

    private Lotto createLotto() {
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            System.out.println("빈 입력입니다.");
            return createLotto();
        }
        String[] splitInput = input.split(SPLIT_REGEX);
        if (splitInput.length != LOTTO_NUM_SIZE) {
            System.out.println("입력값의 로또 번호 개수는 6개이어야 합니다.");
            return createLotto();
        }
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String value : splitInput) {
            if (!Pattern.matches(REGEX, value)) {
                System.out.println("입력값의 문자가 있습니다.");
                return createLotto();
            }
            int number = Integer.parseInt(value);
            if (number < LOTTO_NUM_MIN || number > LOTTO_NUM_MAX) {
                System.out.println("로또 번호 범위에서 벗어난 입력값입니다.");
                return createLotto();
            }
            lottoNumbers.add(new LottoNumber(number));
        }
        Set<LottoNumber> nonDuplicateLottoNumbers = new HashSet<>(lottoNumbers);
        if (nonDuplicateLottoNumbers.size() < LOTTO_NUM_SIZE) {
            System.out.println("로또 번호들은 서로 중복이 되면 안 됩니다.");
            return createLotto();
        }
        return new Lotto(lottoNumbers);
    }

    private LottoNumber createBonusNo(Lotto winningLotto) {
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            System.out.println("빈 입력입니다.");
            return createBonusNo(winningLotto);
        }
        if (!Pattern.matches(REGEX, input)) {
            System.out.println("입력값의 문자가 있습니다.");
            return createBonusNo(winningLotto);
        }
        int bonusNo = Integer.parseInt(input);
        if (bonusNo < LOTTO_NUM_MIN || bonusNo > LOTTO_NUM_MAX) {
            System.out.println("로또 번호 범위에서 벗어난 입력값입니다.");
            return createBonusNo(winningLotto);
        }
        LottoNumber bonus = new LottoNumber(bonusNo);
        if (winningLotto.contains(bonus)) {
            System.out.println("보너스 번호는 당첨번호와 중복될 수 없습니다.");
            return createBonusNo(winningLotto);
        }
        return bonus;
    }

    public LottoResult matchWinningLotto(Lottos userLottos, WinningLotto winningLotto) {
        List<Rank> resultList = new ArrayList<>();
        for (Lotto lotto : userLottos.getLottos()) {
            Rank rank = winningLotto.match(lotto);
            resultList.add(rank);
        }
        return new LottoResult(resultList);
    }
}
