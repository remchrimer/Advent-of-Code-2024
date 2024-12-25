package TheHistorians;
import java.io.*;
import java.util.*;

public class FileParser {
    private List<List<Integer>> parseFileToList(String filePath){
        List<List<Integer>> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] curr = line.split("\\s+");
                List<Integer> currLine = new ArrayList<>();
                for (String s : curr) {
                    int currInteger = Integer.parseInt(s);
                    currLine.add(currInteger);
                }
                data.add(currLine);
            }

        } catch (IOException e) {
            throw new RuntimeException(
                    "Error while executing function parseFile in class FileParser: " + e.getMessage());
        }
        return data;
    }

     public DataPair parseFileDataPair(String filePath) {
         List<Integer> list1 = new ArrayList<>();
         List<Integer> list2 = new ArrayList<>();
         try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
             String line;
             while ((line = br.readLine()) != null) {
                 String[] curr = line.split("\\s+");
                 int num1 = Integer.parseInt(curr[0]);
                 int num2 = Integer.parseInt(curr[1]);
                 list1.add(num1);
                 list2.add(num2);
             }
         } catch (IOException e) {
             throw new RuntimeException(
                     "Error while executing function parseFile in class FileParser: " + e.getMessage());
         }
         return new DataPair(list1, list2);
     }

    public List<List<Integer>> parseFile(String filepath){
        return parseFileToList(filepath);
    }

}
