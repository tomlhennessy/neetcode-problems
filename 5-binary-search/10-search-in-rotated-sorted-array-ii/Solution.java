

public class Solution {
  public boolean search(int[] nums, int target) {
    int n = nums.length;
    int lo = 0;
    int hi = n - 1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] == target) {
        return true;
      }

      if (nums[lo] == nums[mid] && nums[mid] == nums[hi]) {
        lo++;
        hi--;
        continue;
      }

      if (nums[lo] < nums[mid]) {
        // left half sorted
        if (nums[lo] <= target && target < nums[mid]) {
          hi = mid - 1;
        } else {
          lo = mid + 1;
        }
      } else if (nums[mid] < nums[hi]) {
        // right half sorted
        if (nums[mid] < target && target <= nums[hi]) {
          lo = mid + 1;
        } else {
          hi = mid - 1;
        }
      } else {
        if (nums[lo] == nums[mid]) { lo++; }
        if (nums[hi] == nums[mid]) { hi--; }
        continue;
      }
    }

    return false;
  }
}
