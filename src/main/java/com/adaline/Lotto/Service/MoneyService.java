package com.adaline.Lotto.Service;

import com.adaline.Lotto.domain.Money;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 돈 서비스 클래스
 *
 * @author 송훤출
 * @version 1.0
 * @since 20.02.18
 */
public class MoneyService {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_MONEY = 0;
    private static final String REGEX = "^[-]?[0-9]+";

    private Scanner scanner = new Scanner(System.in);

    public Money createMoney() {
        System.out.println("구입 금액을 입력하세요.");
        return createMoneyUtil();
    }

    private Money createMoneyUtil() {
        String input = inputString();
        if (input.isEmpty()) {
            System.out.println("빈 입력입니다.");
            return createMoneyUtil();
        }
        if (!Pattern.matches(REGEX, input)) {
            System.out.println("입력값의 문자가 있습니다.");
            return createMoneyUtil();
        }
        long refinedNumber;
        try {
            refinedNumber = toLong(input);
        } catch (NumberFormatException e) {
            System.out.println("입력값이 long범위를 벗어났습니다.");
            return createMoneyUtil();
        }
        if (refinedNumber < MIN_MONEY) {
            System.out.println("금액이 음수가 될 수는 없습니다.");
            return createMoneyUtil();
        }
        if (refinedNumber < LOTTO_PRICE) {
            System.out.println("구입금액이 부족합니다.");
            return createMoneyUtil();
        }
        return new Money(refinedNumber);
    }

    private String inputString() {
        return scanner.nextLine();
    }

    private long toLong(String input) {
        return Long.parseLong(input);
    }
}
