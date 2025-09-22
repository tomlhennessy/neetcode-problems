import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();

    for (int num : nums) {
      freq.put(num, freq.getOrDefault(num, 0) + 1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

    for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
      pq.offer(e);    // push (key, count)
      if (pq.size() > k) {
        pq.poll();    // pop the smallest count;
      }
    }

    int[] ans = new int[k];
    for (int i = k - 1; i >= 0; i--) {
      ans[i] = pq.poll().getKey();
    }
    return ans;
  }
}
