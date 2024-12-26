package TheHistorians.model;

import java.util.*;

public class DataPair {
    private final List<Integer> firstList;
    private final List<Integer> secondList;

    public DataPair(List<Integer> firstList, List<Integer> secondList) {
        this.firstList = new ArrayList<>(firstList); // defensive copy
        this.secondList = new ArrayList<>(secondList);
    }

    public List<Integer> getFirstList() {
        return Collections.unmodifiableList(firstList);
    }

    public List<Integer> getSecondList() {
        return Collections.unmodifiableList(secondList);
    }
}
