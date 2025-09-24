# Problem Restate
Return `out[i] = product(nums) / nums[i]` without division, in O(n) time and O(1) extra space

# Key Design Question
How to multiply "everything but me" without division?

Do two passes with running products:
  - Prefix pass: `out[i] = product of nums[0..i-1]`
  - Suffix pass: multiply in `product of nums[i+1..n-1]`

# Complexities
- Time: O(n) (two linear passes)
- Space: O(1) extra (output array only)

# What I learned
- Split "everything but me" into **left** and **right** products
- Initialise `out[0] = 1` so the first prefix is neutral
- In the suffix pass: **use then update**

# Mistakes to Watch
- Forgetting `out[0] = 1` (base case)
- Updating `suffix` before using it (order matters)
- Returning the wrong array or forgetting to return
