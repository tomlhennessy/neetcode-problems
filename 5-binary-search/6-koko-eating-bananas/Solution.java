class Solution {
  public int minEatingSpeed(int[] piles, int h) {
    int lo = 1;
    int hi = 0;
    for (int p : piles) {
      hi = Math.max(hi, p);
    }

    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (canFinish(piles, mid, h)) {
        hi = mid;                   // feasible => try smaller k
      } else {
        lo = mid + 1;               // not feasible => need larger k
      }
    }

    return lo;
  }

  private boolean canFinish(int[] piles, int k, int h) {
    long hours = 0;                 // guard against sum overflow
    for (int p : piles) {
      hours += (p + k - 1) / k;     // ceil(p / k)
      if (hours > h) {
        return false;
      }
    }

    return hours <= h;
  }
}
