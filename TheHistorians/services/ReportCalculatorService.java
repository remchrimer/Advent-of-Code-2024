package TheHistorians.services;

import TheHistorians.deciders.ReportDecider;

import java.util.List;

public class ReportCalculatorService {
    public void calculateScore(List<List<Integer>> data){
        ReportDecider safe = new ReportDecider();
        safe.evaluateSafeCandidates(data);
        long reports = safe.getSafeLevelCount();

        System.out.println("How many reports are safe? " + reports);
    }
}
