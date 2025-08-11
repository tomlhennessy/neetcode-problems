

public class Solution {
  public int minSubArrayLen(int target, int[] nums) {
    int n = nums.length;
    int left = 0;
    long sum = 0; // safe for large sums
    int minLen = Integer.MAX_VALUE;

    for (int right = 0; right < n; right++) {
      sum += nums[right];

      while (sum >= target) {
        minLen = Math.min(minLen, right - left + 1);
        sum -= nums[left];
        left++;
      }
    }

    if (minLen == Integer.MAX_VALUE) {
      return 0;
    } else {
      return minLen;
    }
  }
}
