# Problem Restate:
Given `temperatures[i]`, for each day find how many days you must wait until a strictly **warmer** day appears; If none, put `0`.

# Key Design question:
- How to find each day's **next greater element to the right** in `O(n)` instead of scanning forward.
- Use a **monotonic stack of indices** (stack holds days whose temps are in strictly decreasing order)
- As soon as warmer temp arrives, pop and resolve distances

# Complexities:
- **Time**: O(n) each index is pushed once and popped at most once
- **Space**: O(n) in worst case (strictly decreasing temps) the stack holds all indices

# What I learned:
- Store indices, not values - lets you both compare temperatures and compute gaps
- Temps decrease as you go down the stack (invariant), this ensures a new **warmer** day can resolve **multiple** prior days in one go
- Java zero-initialises `new int[n]`, so unresolved days naturally stay `0`

# Mistakes Made:
- Initially considered storing raw temps on the stack -> can't compute distances
- Missing the emptiness check in `while` condition
