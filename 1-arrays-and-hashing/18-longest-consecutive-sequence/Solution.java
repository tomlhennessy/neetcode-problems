import java.util.HashSet;
import java.util.Set;

class Solution {
  public int longestConsecutive(int[] nums) {
    if (nums.length == 0) { return 0; }
    Set<Integer> set = new HashSet<>();

    for (int x : nums) {
      set.add(x);
    }

    int best = 0;
    for (int x : set) {
      if (!set.contains(x - 1)) {
        int curr = x;
        int len = 1;
        while (set.contains(curr + 1)) {
          curr++;
          len++;
        }
        best = Math.max(best, len);
      }
    }
    return best;
  }
}
