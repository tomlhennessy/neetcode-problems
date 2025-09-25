import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<Integer> majorityElement(int[] nums) {
    int n = nums.length;
    int cand1 = 0;
    int cand2 = 1;
    int cnt1 = 0;
    int cnt2 = 0;

    for (int x : nums) {
      if (x == cand1) {
        cnt1++;
      } else if (x == cand2) {
        cnt2++;
      } else if (cnt1 == 0) {
        cand1 = x;
        cnt1 = 1;
      } else if (cnt2 == 0) {
        cand2 = x;
        cnt2 = 1;
      } else {
        cnt1--;
        cnt2--;
      }
    }

    cnt1 = 0;
    cnt2 = 0;
    for (int x : nums) {
      if (x == cand1) {
        cnt1++;
      } else if (x == cand2) {
        cnt2++;
      }
    }

    List<Integer> res = new ArrayList<>();
    if (cnt1 > n / 3) {
      res.add(cand1);
    }
    if (cand2 != cand1 && cnt2 > n / 3) {
      res.add(cand2);
    }

    return res;
  }
}
