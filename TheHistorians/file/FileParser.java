package TheHistorians.file;
import TheHistorians.model.DataPair;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser {
    private final String REGEXEMPTYSTRING = "\\s+";
    private boolean disable;

    private List<String> parseFileToList(String filePath) {
        List<String> parsedData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                parsedData.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(
                    "Error while executing function parseFile in class FileParser: " + e.getMessage());
        }
        return parsedData;
    }

    public List<String> parseFile(String filepath) {
        return parseFileToList(filepath);
    }

    public DataPair parseFileToDataPair(List<String> parsedData) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        try {
            for(String line : parsedData) {
                String[] curr = line.split(REGEXEMPTYSTRING);
                int num1 = Integer.parseInt(curr[0]);
                int num2 = Integer.parseInt(curr[1]);
                list1.add(num1);
                list2.add(num2);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(
                    "Error while executing function parseFile in class FileParser: " + e.getMessage());
        }
        return new DataPair(list1, list2);
    }

    public List<List<Integer>> parseFileToReport(List<String> parsedData) {
        List<List<Integer>> data = new ArrayList<>();
        try{
            for (String line : parsedData) {
                String[] curr = line.split(REGEXEMPTYSTRING);
                List<Integer> currLine = new ArrayList<>();
                for (String s : curr) {
                    int currInteger = Integer.parseInt(s);
                    currLine.add(currInteger);
                }
                data.add(currLine);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(
                    "Error while executing function parseFile in class FileParser: " + e.getMessage());
        }
        return data;
    }

    public List<List<Integer>> parseFileToCorrupt(List<String> corruptedData) {
        List<List<Integer>> data = new ArrayList<>();
        try {
            String REGEXMUL = "mul\\((\\d+),(\\d+)\\)|don't\\(\\)|do\\(\\)";
            Pattern p = Pattern.compile(REGEXMUL);
            disable = false;
            for (String s : corruptedData) {
                Matcher m = p.matcher(s);
                List<Integer> currLine = enableListOnly(m);
                data.addAll(separateToPairs(currLine));
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Error while running function parseFileCorruptedData from class FileParser: "
                    + e.getMessage());
        }
        return data;
    }

    private List<List<Integer>> separateToPairs(List<Integer> currLine) {
        List<List<Integer>> data = new ArrayList<>();
        for (int i = 1; i < currLine.size(); i += 2) {
            List<Integer> pair = new ArrayList<>();
            pair.add(currLine.get(i - 1));
            pair.add(currLine.get(i));
            data.add(pair);
        }
        return data;
    }

    private List<Integer> enableListOnly(Matcher m) {
        List<Integer> enableList = new ArrayList<>();
        while (m.find()) {
            String curr = m.group();
            if (curr.equals("don't()")) {
                disable = true;
            } else if (curr.equals("do()")) {
                disable = false;
            } else if (curr.startsWith("mul(") && !disable) {
                enableList.add(Integer.parseInt(m.group(1)));
                enableList.add(Integer.parseInt(m.group(2)));
            }
        }
        return enableList;
    }
}