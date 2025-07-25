import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<Integer> majorityElement(int[] nums) {
    Integer candidate1 = null, candidate2 = null;
    int count1 = 0, count2 = 0;

    // candidate selection
    for (int num : nums) {
      if (candidate1 != null && candidate1.equals(num)) {
        count1++;
      } else if (candidate2 != null && candidate2.equals(num)) {
        count2++;
      } else if (count1 == 0) {
        candidate1 = num;
        count1 = 1;
      } else if (count2 == 0) {
        candidate2 = num;
        count2 = 1;
      } else {
        count1--;
        count2--;
      }
    }

    // candidate verification
    List<Integer> res = new ArrayList<>();
    count1 = 0;
    count2 = 0;

    for (int num : nums) {
      if (candidate1 != null && candidate1.equals(num)) {
        count1++;
      }
      if (candidate2 != null && candidate2.equals(num)) {
        count2++;
      }
    }
    if (count1 > nums.length / 3) {
      res.add(candidate1);
    }
    if (count2 > nums.length / 3) {
      res.add(candidate2);
    }

    return res;
  }
}
