package com.adaline.Lotto.util;

import com.adaline.Lotto.domain.Profits;

public class Printer {

    public static void printProfits(Profits profits) {
        System.out.println("총 수익률은 : " +
                profits.calculateEarningRate());
    }
}
