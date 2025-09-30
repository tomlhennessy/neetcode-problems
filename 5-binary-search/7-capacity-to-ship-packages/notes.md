# Problem Restate
Given `weights[i]` and `days`, find the **minimum ship capacity** so all packages can be shipped in order within `days` days.
Each day, load packages sequentially until capacity is reached; can't split packages.

# Key Design Question
How to find the least feasible capacity efficiently?
Predicate `daysNeeded(c) <= days` is **monotonic** (larger `c` => fewer/equal days)
So: use **binary search** on answer


# Algorithm (high level)
Bounds:
- `lo = max(weights)` (must fit heaviest)
- `hi = sum(weights)` (all in one day)
While lo < hi:
- if canShip(mid) true -> hi = mid (mid might be answer)
- else -> lo = mid + 1
Return lo: smallest feasible capacity

# Feasibility Check (canShip)
Simulate loading with capacity `C`:
- Start `neededDays = 1, curr = 0`
- For each `w` in `weights`:
  • If `curr + w <= C` -> add to current day
  • Else -> start new day (`neededDays++`, `curr = w`)
- Return true if `neededDays <= days`

# Why it Works
As capacity grows, days needed only decreases -> monotonic predicate lets binary search find the minimal feasible capacity

# Complexities
- Time: O(n log sum(weights))
- Space: O(1)

# What I Learned
- Always set lower bound to heaviest item, upper bound to sum
- Greedy loading is sufficient since order is fixed
- Pattern is identical to "Koko eating bananas": binary search on answer with monotonic feasibility

# Mistakes to Avoid
- Using `lo = 0` (can't fit heaviest package)
- Forgetting to increment `neededDays` when starting a new day
- Accidentally discarding `mid` when feasible (must keep it: `hi = mid`)
