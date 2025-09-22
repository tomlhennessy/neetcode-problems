# Problem Restate
Return the `k` most frequent integers from `nums`. Order doesn't matter.

# Key Design Question
How to keep only the k largest frequencies efficiently?
- Build a **frequency map**: num -> count
- Maintain a **min-heap** of size `k` ordered by count
  • Push each `(num,count)`
  • If heap size > k -> **pop** the smallest count
  • Heap ends containing exactly the top-k by frequency
- Extract the keys from the heap into the answer

# Complexities
Time: O(n log k) n to count plus each heap op
Space: O(n) freq map plus heap up to k

# What I learned
- **Min-heap of size k** is the standard "top-k" trick
- Java `PriorityQueue` is a **min-heap**; you control ordering via a **Comparator**
- Compare by value (frequency), not by key
- Extraction: heap pops the smallest among the top-k first

# Alternatives
- Bucket Sort

# Mistakes Made
- Forgetting the comparator -> heap orders by entry's natural order (not desired)
- Using `pq.size` instead of `pq.size()` -> compile error
- returning counts instead of keys when extracting
