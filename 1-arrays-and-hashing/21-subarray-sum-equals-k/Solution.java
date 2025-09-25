import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    freq.put(0, 1);
    int sum = 0;
    int count = 0;

    for (int x : nums) {
      sum += x;
      count += freq.getOrDefault(sum - k, 0);         // look back
      freq.put(sum, freq.getOrDefault(sum, 0) + 1);   // record this prefix sum
    }

    return count;
  }
}
