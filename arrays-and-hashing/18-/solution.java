import java.util.HashSet;
import java.util.Set;

class Solution {
  public int longestConsecutive(int[] nums) {
    Set<Integer> lookup = new HashSet<>();
    for (int num : nums) {
      lookup.add(num);
    }

    int max = 0;

    for (int num : lookup) {
      if (!lookup.contains(num - 1)) {
        int current = num;
        int length = 1;
        while (lookup.contains(current + 1)) {
          current++;
          length++;
        }
        max = Math.max(max, length);
      }
    }

    return max;
  }
}
