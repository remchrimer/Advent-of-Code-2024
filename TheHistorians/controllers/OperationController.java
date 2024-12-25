package TheHistorians.controllers;

import TheHistorians.DataPair;
import TheHistorians.FileParser;
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
            if(operation.equals("--calculateScore")) {
                DataPair dataPair = reader.parseFileDataPair(file);
                ScoreCalculatorService scoreCalculatorService = new ScoreCalculatorService();
                scoreCalculatorService.calculateScore(dataPair);
            }
            else if(operation.equals("--calculateReports")) {
                List<List<Integer>> data = reader.parseFile(file);
                ReportCalculatorService reportCalculatorService = new ReportCalculatorService();
                reportCalculatorService.calculateScore(data);
            }
            else {
                System.err.println("Unknown operation: " + operation);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
