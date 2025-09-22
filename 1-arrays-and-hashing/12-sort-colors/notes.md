# Problem Restate
Given an array with only `0`, `1`, `2`, sort it in-place to non-decreasing order

# Key Design Question
How to partition in one pass, O(1) space?

Maintain three regions with pointers:
  - `lo`: next spot for `0`
  - `mid`: current element to inspect
  - `hi`: next spot for `2`

Invariants after every step:
  - `[0 .. lo-1]`     -> all `0`s
  - `[lo .. mid-1]`   -> all `1`s
  - `[mid .. hi]`     -> unknown
  - `[hi+1 .. n-1]`   -> all `2`s

# Why it Works
- `0` belongs at the front -> expand the left region and move forward
- `1` already in the middle region -> just move forward
- `2` belongs at the back -> swap it toward the end; re-check the new `nums[mid]`

# Complexities
Time: O(n) - each element moved at most once/twice
Space: O(1) - swaps in-place

# What I learned
- Define and maintain **clear invariants**; they guide the pointer updates
- The loop condition is `mid <= hi` - ensures all unknowns get processed
- After swapping a `2` to the end, **recheck** the new `nums[mid]` (no `mid++`)

# Mistakes Made
- Using `while (mid < hi)` instead of `<=` -> last element may be skipped
- Incrementing `mid` after handling a `2` -> can skip an unprocessed value
- Forgetting to increment both `lo` and `mid` after placing a `0`
