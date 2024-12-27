package TheHistorians.deciders;
import java.util.*;

public class ReportDecider {
    private int count;
    private List<List<Integer>> safeCandidate;

    private enum Direction {
        INCREASING,
        DECREASING
    }

    public void evaluateSafeCandidates(List<List<Integer>> candidates) {
        safeCandidate = new ArrayList<>();
        processOriginal(candidates);
        processDampener(safeCandidate);
    }

    public void processOriginal(List<List<Integer>> candidates){
        for(List<Integer> d : candidates){
            if(d.size() <= 1){
                count = count + 1;
                continue;
            }
            Direction dir = determineDirection(d);
            boolean isValid = isSafeCandidate(d, dir);
            if(isValid){
                count++;
            }
            else{
                safeCandidate.add(d);
            }
        }
    }

    public void processDampener(List<List<Integer>> safeCandidate){
        for (List<Integer> candidate : safeCandidate) {
            Direction dir = determineDirection(candidate);
            for (int i = 0; i < candidate.size(); i++) {
                List<Integer> modifiedCandidate = new ArrayList<>(candidate);
                modifiedCandidate.remove(i);
                if (isSafeCandidate(modifiedCandidate, dir)) {
                    count++;
                    break;
                }
            }
        }
    }

    private Direction determineDirection(List<Integer> data){
        int increasingCount = 0;
        int decreasingCount = 0;

        for (int i = 1; i < data.size(); i++) {
            if (data.get(i) > data.get(i - 1)) {
                increasingCount++;
            } else if (data.get(i) < data.get(i - 1)) {
                decreasingCount++;
            }
        }
        return increasingCount > decreasingCount ? Direction.INCREASING : Direction.DECREASING;
    }

    private boolean isSafeCandidate(List<Integer> sequence, Direction dir) {
        for (int i = 1; i < sequence.size(); i++) {
            int diff = Math.abs(sequence.get(i) - sequence.get(i - 1));
            switch (dir) {
                case INCREASING:
                    if (diff < 1 || diff > 3 || sequence.get(i) < sequence.get(i - 1)) {
                        return false;
                    }
                    break;
                case DECREASING:
                    if (diff < 1 || diff > 3 || sequence.get(i) > sequence.get(i - 1)) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

    public int getSafeLevelCount(){
        return count;
    }
}