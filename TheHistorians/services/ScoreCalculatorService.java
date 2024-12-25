package TheHistorians.services;

import TheHistorians.DataPair;
import TheHistorians.DistanceCalculator;

public class ScoreCalculatorService {
    public void calculateScore(DataPair dataPair) {
        DistanceCalculator result = new DistanceCalculator();

        long answer = result.distanceCalculate(dataPair);
        long score = result.similarityScore(dataPair);

        System.out.println("Total distance between your lists is " + answer);
        System.out.println("Their similarity score is " + score);
    }
}
