# Problem Restate
Return the length of the longest run of integers that appear consecutively (e.g. 2,3,4,5) in any order in the array

# Key Design
Use a HashSet for O(1) membership, and only grow sequences from their starts:
  - Put all numbers into a `set`
  - For each `x` in `set`, if `x-1` is **not** in `set`, then `x` is a start
  - Walk forward: `curr = x`, `len = 1`; while `set.contains(curr + 1)`, do `curr++`, `len++`
  - Track `best = max(best, len)`; return best

Why it's O(n) -> each run is expanded once, from its unique smallest element

# Complexities
Time: O(n) average
Space: O(n) for the set

# What I Learned
- Starts-only rule: test `x-1` not in set to avoid re-counting
- Duplicate don't matter (set dedups)
- No need to store runs; just keep `best` length

# Mistakes to Avoid
- Starting counts at every element (becomes O(n^2))
- Iterating the array and missing starts due to duplicates - iterate the set
