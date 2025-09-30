

public class Solution {
  public int shipWithinDays(int[] weights, int days) {
    int lo = 0;
    int hi = 0;
    for (int w : weights) {
      lo = Math.max(lo, w);   // at least the heaviest package
      hi += w;                // at most all in one day
    }

    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (canShip(weights, days, mid)) {
        hi = mid;             // feasible -> try smaller capacity
      } else {
        lo = mid + 1;         // not feasible -> need more capacity
      }
    }
    return lo;
  }

  private boolean canShip(int[] weights, int days, int cap) {
    int needed = 1;
    int curr = 0;
    for (int w : weights) {
      if (curr + w <= cap) {
        curr += w;
      } else {
        needed++;
        if (needed > days) return false;    // early exit
        curr = w;
      }
    }
    return true;
  }
}
