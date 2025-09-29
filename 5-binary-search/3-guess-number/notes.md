# Problem Restate
Find the hidden number in `1..n` using the `guess(num)` API
- `0` if equal
- `-1` if guess to high
- `1` if guess to low

# Key Design Question
How to find the number in O(log n) time instead of O(n)?
Use **binary search**: shrink range in half each step based on feedback.

# Complexities
Time: O(log n) halving each step
Space: O(1) only pointers and variables

# What I learned
- `guess()` is inherited from `GuessGame`; don't override it, just call it
- Safe midpoint formula avoids overflow `l + (r - l) / 2`
- Binary search isn't just for arrays - it applies whenever you have ordered feedback

# Mistakes to avoid
- Writing `mid = (l + r) / 2` (risk of overflow)
