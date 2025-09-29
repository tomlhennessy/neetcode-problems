# Problem Restate
Find the **minimum integer rate** `k` (bananas/hour) so Koko can finish all `piles` within `h` hours.
Each hour she chooses one pile and eats up to `k` bananas from it.

# Key Design Question
How to find `k` efficiently?

Use **binary search** on the answer because the predicate `hours(k) <= h` is **monotonic** (larger `k` => never more hours)

# Feasability Check
Hours for one pile `p` at speed `k` = **ceil(p / k)**
Integer-only: `(p + k - 1) / k`
Total hours = sum over all piles
`k` is feasible if total <= `h`

# Bounds
- `lo = 1` (slowest non-zero speed)
- `hi = max(piles)` (fast enough to finish the largest pile in <= 1 hour; can't need more)

# Binary Search Rule
- If `k` is feasible -> try smaller: `hi = mid`
- If not feasible -> need bigger: `lo = mid + 1`
Stop when `lo == hi` -> minimal feasible `k`

# Why It Works
The required hours decrease monotonically with `k`, so binary search finds the smallest `k` that satisfies the time limit.

# Complexities
- Time: O(n log max(piles))
- Space: O(1)

# Mistakes to avoid
- Using floats for ceiling - use `(p + k - 1) / k`
- Wrong bounds (start at 1, end at `max(piles)`)
- Reversing the feasible/non-feasible updates

