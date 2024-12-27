package TheHistorians.services;

import TheHistorians.deciders.ScoreDecider;
import TheHistorians.model.DataPair;

public class ScoreCalculatorService {
    public void calculateScore(DataPair dataPair) {
        ScoreDecider result = new ScoreDecider();

        long answer = result.distanceCalculate(dataPair);
        long score = result.similarityScore(dataPair);

        System.out.println("Total distance between your lists is " + answer);
        System.out.println("Their similarity score is " + score);
    }
}
