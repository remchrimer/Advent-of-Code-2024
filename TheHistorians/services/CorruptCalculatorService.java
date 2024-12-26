package TheHistorians.services;

import java.util.List;

public class CorruptCalculatorService {
    public void calculateMultiple(List<List<Integer>> data) {
        CorruptDecider multiplicationDecider = new CorruptDecider();
        multiplicationDecider.decryptMultiply(data);
        long multiplicationCorrupt = multiplicationDecider.getMultiplicationResult();

        System.out.println("What do you get if you add up all of the results of the multiplications? " + multiplicationCorrupt);
    }
}
