package TheHistorians.services;

import TheHistorians.SafeDecider;

import java.util.List;

public class ReportCalculatorService {
    public void calculateScore(List<List<Integer>> data){
        SafeDecider safe = new SafeDecider();
        safe.evaluateSafeCandidates(data);
        long reports = safe.getSafeLevelCount();

        System.out.println("How many reports are safe? " + reports);
    }
}
