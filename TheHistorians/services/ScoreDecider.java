package TheHistorians.services;
import TheHistorians.model.DataPair;

import java.util.*;

public class ScoreDecider {
    private static final long mod = 1_000_000_007;

    public long similarityScore(DataPair data) {
        List<Integer> list1 = data.getFirstList();
        List<Integer> list2 = data.getSecondList();
        Map<Integer, Integer> map = new HashMap<>();
        long score = 0;
        for (int i : list1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : list2) {
            score = (score + (long) i * map.getOrDefault(i, 0)) % mod;
        }
        return score % mod;
    }

    public long distanceCalculate(DataPair data) {
        List<Integer> list1 = new ArrayList<>(data.getFirstList());
        List<Integer> list2 = new ArrayList<>(data.getSecondList());

        // Sort the list
        Collections.sort(list1);
        Collections.sort(list2);

        long ans = 0;
        for (int i = 0; i < list1.size(); i++) {
            long diff = Math.abs(list1.get(i) - list2.get(i));
            ans = (ans + diff) % mod;
        }
        return ans % mod;
    }

}
