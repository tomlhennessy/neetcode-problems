# Problem Restate
Remove all occurances of `val` from `nums` **in-place**.
Return the new length `k`; the first `k` elements of `nums` must be the kept values. Contents after `k` don't matter.

# Key Design Question
How to overwrite only the elements we keep?
Use two pointers:
- `r` = read index (scan every element)
- `l` = write index (next position to write a kept element)
Rule: if `nums[r] != val`, copy forward -> `nums[l] = nums[r]; l++`

# Minimal template
```java
class Solution {
  public int removeElement(int[] nums, int val) {
    int l = 0;
    for (int r = 0; r < nums.length; r++) {
      if (nums[r] != val) {
        nums[l] = nums[r];
        l++;
      }
    }
    return l;
  }
}
```

# Why it Works
- `l` always points to the next write slot
- Everything in `nums[0...l-1]` is a kept value
- We never move `l` on a removal - so the removed values are skipped, not written.

# Complexities
Time: O(n)
Space: 0(1)


