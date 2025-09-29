# Problem Restate
Return `true` if `target` exists in an `m x n` matrix where:
- Each row sorted ascending
- First element of each row > last element of previous row

# Key Design Question
How to achieve O(log(m·n)) search?

Flatten the matrix conceptually into a **1-D sorted array** of length `m·n`, then apply binary search.


