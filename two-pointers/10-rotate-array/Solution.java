

public class Solution {
  public void rotate(int[] nums, int k) {
    k %= nums.length;

    if (k == 0 || nums.length <= 1) {
      return;
    }

    // reverse whole array
    reverse(nums, 0, nums.length - 1);
    // reverse first k nums
    reverse(nums, 0, k - 1);
    // reverse rest
    reverse(nums, k, nums.length - 1);
  }

  private void reverse(int[] nums, int left, int right) {
    while (left < right) {
      int temp = nums[left];
      nums[left]= nums[right];
      nums[right] = temp;

      left++;
      right--;
    }
  }
}
