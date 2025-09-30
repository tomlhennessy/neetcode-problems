# Problem Restate
Given a sorted array rotated 1-n times, return the **minimum element**.
All elements unique. Must run in O(log n)

# Key Design Question
Where is the pivot (rotation point)?
Since the array is "sorted but rotated", we can use binary search to shrink the window

# Why it Works
Comparing `nums[mid]` with `nums[r]` reveals which half is sorted; the minimum must lie in the **unsorted** half

# Complexities
Time: O (log n)
Space: O(1)

# What I Learned
- Use `nums[mid] vs nums[r]` to decide pivot side
- Keep `mid` when it could be the min (`r = mid`)
- Check `nums[l] <= nums[r]` for early exit when the window already sorted

# Mistakes to Avoid
- Using `while (l <= r)` (will overshoot)
- Doing `r = mid - 1` and dropping the true min
- Forgetting the early exit check for sorted window
