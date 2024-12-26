package TheHistorians.controllers;

import TheHistorians.model.DataPair;
import TheHistorians.file.FileParser;
import TheHistorians.services.CorruptCalculatorService;
import TheHistorians.services.ReportCalculatorService;
import TheHistorians.services.ScoreCalculatorService;
import java.util.List;

public class OperationController {
    private final String file;
    public OperationController(String file) {
        this.file = file;
    }
    public void executeOperation(String operation) {
        try{
            FileParser reader = new FileParser();
            switch (operation) {
                case "--calculateScore" -> {
                    List<String> data = reader.parseFile(file);
                    DataPair dataPair = reader.parseFileToDataPair(data);
                    ScoreCalculatorService scoreCalculatorService = new ScoreCalculatorService();
                    scoreCalculatorService.calculateScore(dataPair);
                }
                case "--calculateReports" -> {
                    List<String> data = reader.parseFile(file);
                    List<List<Integer>> scoreData = reader.parseFileToReport(data);
                    ReportCalculatorService reportCalculatorService = new ReportCalculatorService();
                    reportCalculatorService.calculateScore(scoreData);
                }
                case "--calculateMultiplication" -> {
                    List<String> corruptedData = reader.parseFile(file);
                    List<List<Integer>> data = reader.parseFileToCorrupt(corruptedData);
                    CorruptCalculatorService corruptCalculatorService = new CorruptCalculatorService();
                    corruptCalculatorService.calculateMultiple(data);
                }
                default -> System.err.println("Unknown operation: " + operation);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
