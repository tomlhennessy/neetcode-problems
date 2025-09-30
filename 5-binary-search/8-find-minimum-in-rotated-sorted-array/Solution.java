

public class Solution {
  public int findMin(int[] nums) {
    int l = 0;
    int r = nums.length - 1;

    while (l < r) {
      if (nums[l] <= nums[r]) {
        return nums[l];         // window already sorted
      }

      int mid = l + (r - l) / 2;

      if (nums[mid] > nums[r]) {
        l = mid + 1;           // min in right half
      } else {
        r = mid;               // min at mid or in left half
      }
    }

    return nums[l];
  }
}
