# Problem Restate
Return the **maximum depth** of a binary tree:
the number of nodes on the longest path from the root to any leaf.

# Key Design Question
How can we compute the depth by letting **each node** report the depth of its own subtree?

Define depth recursively:
```java
depth(node) = 1 + max(depth(left), depth(right))
```
Base case: an empty tree has depth 0;

# Why It Works
1. A node's depth depends only on its left and right subtree depths
2. Leaf nodes return 1 (no children -> max(0, 0) + 1)
3. Internal nodes build depth upward:
  - recursion reaches leaves
  - computes depth bottom-up
4. The final return value at the root is the depth of the entire tree
5. No extra structures needed - recursion implicitly handles traversal

# Complexities
Time: O(n) - every node visited once
Space: O(h) - recursion stack
Worst-case: O(n) for skewed tree
Best-case: O(log n) for balanced tree

# What I Learned
- Depth = height = longest root->leaf path
- Natural recursion: each call computes **its own** subtree height
- Base case: null returns 0
- Combine recursive results using:
```java
1 + Math.max(leftDepth, rightDepth)
```

# Mistakes to Avoid
- Forgetting the base case
- Adding extra data structures (unnecessary)
- Trying to track depth top-down with mutable state (harder)
- Mixing up depth definitions (depth counts nodes, not edges)
