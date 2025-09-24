# Problem Restate
Preprocess a 2D matrix so `sumRegion` returns the sum of that rectangle in O(1) time.

# Key Design Question
How to answer rectangle sums in O(1)?
-> Build a **2D prefix sum** (with **+1 padding**) so each query is 4 array-reads.

# Complexities
Build: O(m·n)
Query: O(1)
Space: O(m·n) for `pref`

# What I learned
- Padding by 1 kills boundary `if`s; index math stays clean
- Inclusion-exclusion in 2D: cell + top + left - top-left

# Mistakes to Avoid
- Off-by-one in loops
- Forgetting the +1 shift in both build and query
- Mixing unpadded indices with padded ones
- Trying to recompute sums per query (breaks O(1) requirement)
