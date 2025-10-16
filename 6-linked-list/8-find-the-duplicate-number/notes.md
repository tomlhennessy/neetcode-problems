# Problem Restate
Given `nums` of length `n+1` with values in `[1..n]`, exactly one number appears at least twice. Return that duplicate. Do it without modifying nums and in O(1) extra space.

# Key Design Question
How can we find a duplicate in O(1) space without sorting or marking?
-> Treat the array as a **linked list**: index `i` points to `nums[i]`. There must be a **cycle**; the duplicate is the **cycle entry**.

# Why It Works
- Nodes: indices `0..n`; edges: `i -> nums[i]` (all edges go to `1..n`)
- With `n+1` nodes pointing to `n` targets, by pigeonhole there's a cycle
- Floyd's Tortoise-Hare:
  • Phase 1: `slow = nums[slow]`, `fast = nums[nums[fast]]` -> they meet inside the cycle
  • Phase 2: move one pointer to `nums[0]`; Advance both one step. Meeting point point = **cycle entry** = duplicate value

# Core Pattern (Floyd)
```java
class Solution {
  public int findDuplicate(int[] nums) {
    int slow = nums[0];
    int fast = nums[0];
    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);

    int ptr1 = nums[0];
    int ptr2 = slow;
    while (ptr1 != ptr2) {
      ptr1 = nums[ptr1];
      ptr2 = nums[ptr2];
    }
    return ptr1;
  }
}
```

# Complexities
• Time: O(n)
• Space: O(1) extra

# What I Learned
- Model arrays as graphs to use cycle detection
- Duplicate value = entry in the index -> value mapping
- Two pointer phase split: **meet**, then **find entry**

# Mistakes to Avoid
- Starting pointers at 0 instead of `nums[0]`
- Using `while (slow != fast)` without moving first (prefer `do-while`)

