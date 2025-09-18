import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> seen = new HashMap<>();
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      int difference = target - nums[i];
      if (seen.containsKey(difference)) {
        return new int[] {seen.get(difference), i};
      }
      seen.put(nums[i], i);
    }

    return new int[0];
  }
}
