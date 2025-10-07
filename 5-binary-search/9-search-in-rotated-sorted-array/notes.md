# Problem Restate
Given a **rotated sorted array** (unique elements), find the **index of target** or return `-1`.
Must run in O(log n) -> so binary search logic applies

# Key Design Question
At each step:
- Which half is sorted? left or right?
- Does the target lie in that sorted half, or the other unsorted one?

# Why It Works
Because rotation preserves sorting within one side of any midpoint.
So each step we can:
1. Identify the sorted side (`nums[lo] <= nums[mid]` means left sorted)
2. Check if target is within that side's range
3. Shrink search window toward the half containing target

This halves the search space.

# Complexities
- Time: O(log n)
- Space: O(1)

# What I Learned
- In rotated arrays, **one side is always sorted** - use that invariant.
- Use `nums[lo] <= nums[mid]` to detect left-sorted half
- Closed interval means `while (lo <= hi)` and updates with `±1`
- Use strict `<` on upper bound to prevent infinite loops
- Always check equality first (`nums[mid] == target`)

# Mistakes to Avoid
- Using `while (lo < hi)` -> misses last element
- Forgetting to move pointers by ±1 -> infinite loop
- Mixing up `<` vs `<=` in the range check
- Assuming both sides could be unsorted - only one ever is
- Forgetting that target might be in either sorted or unsorted side

