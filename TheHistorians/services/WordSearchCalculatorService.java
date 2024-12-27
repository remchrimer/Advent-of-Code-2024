package TheHistorians.services;

import TheHistorians.deciders.WordSearchDecider;

public class WordSearchCalculatorService {
    public void searchWord(char[][] data) {
        WordSearchDecider decider = new WordSearchDecider();

        long wordCount = decider.calculateWordCount(data);
        long xCount = decider.calculateXwordCount(data);

        System.out.println("Total word count: " + wordCount);
        System.out.println("Total xword count: " + xCount);
    }
}
