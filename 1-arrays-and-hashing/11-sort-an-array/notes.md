# Problem Restate
Sort an integer array in ascending order in O(n log n) without built-ins, using as little extra stress as practical.

# Key Design Question
How to do O(n log n) sorting with predictable space
- Use **top-down mergesort** with **one reusable temp-array**
- Recurrance: sort `[l..m]`, sort `[m+1..r]`, then **merge** the two sorted halves
- Merge trick: copy `a[l..r]` into `temp[l..r]` then write back to `a` using two pointers
  • Only copy **left leftovers**; **right leftovers are already in place**
    (when left exhausts, `k == j`, so tail of right half sits untouched in `a[k..r]`).

# Complexities
**time**: O(n log n)
**space**: O(n) extra for the single `tmp` array (minimal for mergesort)

# What I learned:
- Base case by range (`l <= r`), not array length
- Overflow-safe mid: `m = (r - l) / 2`

# Mistakes made:
- Used `if (a.length == 1)` instead of `if (l >= r)`
- Confusion on right leftovers: when left finishes `k == j` -> right tail untouched in `a`
- Off-by-one in the temp copy loop
