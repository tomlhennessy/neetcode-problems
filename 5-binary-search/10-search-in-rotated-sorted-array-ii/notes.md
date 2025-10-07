# Problem Restate
Given a **rotated sorted array** (non-decreasing, duplicates allowed), return **true/false** if `target` exists.
Goal: **fewest steps**, ideally O(log n), but duplicates can force O(n) in worst case.

# Key Difference vs. "Distinct" version
Duplicates can make the "which half is sorted" test **ambiguous** when
`nums[lo] == nums[mid] == nums[hi]`
We must **shrink both ends** in this case to make progress.

# Why It Works
At each step either:
1. You find `target` at `mid`, or
2. If not ambiguous, **exactly one half is strictly sorted** -> range-check and discard the other half, or
3. If ambiguous (`lo==mid==hi`), **contract** both ends by 1 to break symmetry.

This maintains correctness while usually halving the search space.

# Bound Rules (cheat sheet)
- **Detect sorted side**: use **strict** `<`
  • Left sorted -> `nums[lo] < nums[mid]`
  • Right sorted -> `nums[mid] < nums[hi]`
- Range test inside sorted side:
  • closer to `mid` -> **strict** `<` (prevents stall)
  • away from `mid` -> **inclusive** `<=` (don't miss boundary)
  • Left in-range: `nums[lo] <= target && target < nums[mid]`
  • Right in-range: `nums[mid] < target && target <= nums[hi]`

# Ambiguity Case
When `nums[lo] == nums[mid] == nums[hi]` and `nums[mid] != target`, both ends carry the same value as `mid`
- Action: `lo++`, `hi--`, then `continue`
- Safety: if `target` were that value, we'd have matched at mid
- Purpose: breaks symmetry; guarantees progress

# Complexities
- Average: O(log n) (keeps discarding halves)
- Worst Case: O(n) (many identical values)
- Space: O(1)

# What I Learned
- Duplicates require a **third branch**: the **ambiguous contraction**
- Use **strict** comparisons to assert a side is truly sorted
- Keep **closed interval** with `while (lo <= hi)` and move by `±1`
- Equality check goes first to short circuit success

# Mistakes to avoid
- Using `<=` to detect sorted side (re-introduces ambiguity)
- Forgetting **inclusive** bound on the side away from mid
- Dropping the `continue;` after contracting (reuses stale `mid`)
- Switching to `while (lo < hi)` (can miss the last index)
