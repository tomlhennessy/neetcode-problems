

public class Solution {
  public int search(int[] nums, int target) {
    int n = nums.length;
    int lo = 0;
    int hi = n - 1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] == target) { return mid; }

      if (nums[lo] <= nums[mid]) {
        // left half sorted
        if (nums[lo] <= target && target < nums[mid]) {
          hi = mid - 1;
        } else {
          lo = mid + 1;
        }
      } else {
        // right half sorted
        if (nums[mid] < target && target <= nums[hi]) {
          lo = mid + 1;
        } else {
          hi = mid - 1;
        }
      }
    }

    return -1;
  }
}
