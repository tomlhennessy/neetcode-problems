import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 3; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      for (int j = i + 1; j < nums.length - 2; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }

        int l = j + 1;
        int r = nums.length - 1;

        while (l < r) {
          long total = (long) nums[i] + nums[j] + nums[l] + nums[r];

          if (total > target) {
            r--;
          } else if (total < target) {
            l++;
          } else {
            res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
            l++;
            r--;

            while (l < r && nums[l] == nums[l - 1]) {
              l++;
            }
            while (l < r && nums[r] == nums[r + 1]) {
              r--;
            }
          }
        }

      }
    }

    return res;
  }
}
