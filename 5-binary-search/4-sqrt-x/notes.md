# Problem Restate
Return the floor of √x for non-negative integer `x` without using `pow` or `**`

# Key Design Question
How to compute √x in O(log x) time, avoiding overflow?

Use **binary search**: test squares until the range collapses.

# Why it Works
binary search narrows in on the largest integer whose square does not exceed `x`

# Complexities
Time: O(log x) (halving range each step)
Space: O(1)

# What I Learned
- Use `long` for `mid * mid` to avoid overflow
- Always return immediately when `sq` is exact -> prevents infinite loop
- Store candidate result (`res`) when square is below `x`

# Mistakes to Avoid
- Forgetting to update bounds in the equality branch -> infinite loop
- using `int mid * mid` directly -> overflow for large `x`

