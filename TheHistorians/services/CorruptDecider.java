package TheHistorians.services;
import java.util.*;

public class CorruptDecider {
    private long multiplcationResult;
    private static final long MODULO = 1_000_000_007;

    public void decryptMultiply(List<List<Integer>> data){
        multiplcationResult = 0;
        for(List<Integer> d : data){
            multiplcationResult += multiply(d.get(0), d.get(1));
        }
    }

    private long multiply(int a, int b) {
        return (long) a * b % MODULO;
    }

    public long getMultiplicationResult() {
        return multiplcationResult;
    }
}
