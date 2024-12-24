import java.io.*;
import java.util.*;

public class FileParser {
    private static final int NUM1_INDEX = 0;
    private static final int NUM2_INDEX = 3;

    public DataPair parseFile(String filePath) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] curr = line.split(" ");
                int num1 = Integer.parseInt(curr[NUM1_INDEX]);
                int num2 = Integer.parseInt(curr[NUM2_INDEX]);
                list1.add(num1);
                list2.add(num2);
            }

        } catch (IOException e) {
            throw new RuntimeException(
                    "Error while executing function parseFile in class FileParser: " + e.getMessage());
        }
        return new DataPair(list1, list2);
    }
}
