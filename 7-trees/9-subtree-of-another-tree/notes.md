# Problem Restate
Return true if **subRoot** appears as a subtree anywhere inside **root**, meaning:
- Structures must match
- Node values must match
- Match must be **rooted** at some node within root

# Key Design Question
How can we efficiently determine if subRoot matches **any** node inside root?

Use a two-part strategy:
1. Traverse root looking for possible starting points
2. At each node, check if the tree starting there is **identical** to subRoot

This uses a combination of:
• isSubTree -> searches
• isSameTree -> verifies exact match

# Why It Works
1. Every subtree candidate starts at some node inside root.
2. For each node:
  - if values match, check full structural equality via isSameTree
3. If exact match found -> return True
4. If not, recursively search left and right subtrees
5. isSameTree guarantees:
  - same shape
  - same values
  - same null placements
This ensures correctness while only traversing each node once or twice.

# Complexities
Time: O(n x m) worst case
• n = nodes in root
• m = nodes in subRoot
  For each node in root, we may compare an entire subRoot

But given constraints (<= 100 nodes), this is fine

Space: O(h) recursion stack
Worst case O(n), best case O(log n) for balanced trees

# What I Learned
- Subtree check = search + exact-compare
- isSameTree must be used to confirm a match
- isSubTree continues searching if a match is not found at the current root
- Null cases matter:
  • root == null -> false
  • subRoot == null -> true (empty tree is a subtree)

# Mistakes to Avoid
- Forgetting to check equality at the **current node** before recursing
- Comparing node values before null checks in isSameTree
- Calling isSameTree instead of isSubTree on left/right branches
- Forgetting tree equality must check structure and values
