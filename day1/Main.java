public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("TXT file is not given");
            return;
        }
        String file = args[0];

        try {
            FileParser reader = new FileParser();
            DataPair data = reader.parseFile(file);
            DistanceCalculator result = new DistanceCalculator();

            long answer = result.distanceCalculate(data);
            long score = result.similarityScore(data);

            System.out.println("total distance between your lists is " + answer);
            System.out.println("their similarity score is " + score);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

/*
 * Approach:
 * 
 * 1. Read the input file, say that its txt file
 * 2. seperate each line to two different parts
 * 3. sort them
 * 4. calculate the difference
 * 5. add the difference to total
 * 6. return total distance
 */