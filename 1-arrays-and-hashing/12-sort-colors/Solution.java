
public class Solution {
  public void sortColors(int[] nums) {
    int n = nums.length;
    int lo = 0;
    int mid = 0;
    int hi = n - 1;

    while (mid <= hi) {
      if (nums[mid] == 0) {
        swap(nums, mid, lo);
        mid++;
        lo++;
      } else if (nums[mid] == 1) {
        mid++;
      } else if (nums[mid] == 2) {
        swap(nums, mid, hi);
        hi--;
      }
    }
  }

  private void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
