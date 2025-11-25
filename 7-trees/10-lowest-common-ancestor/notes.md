# Problem Restate
Given a binary search tree (BST) and two nodes p and q, return their **lowest common ancestor**
- the lowest node in the tree that has both p and q as descendants.
(A node can be a descendant of itself)

# Key Design Question
How can we use the **BST property** to locate the LCA without searching both sides
BST guarantees:
```java
left subtree < node.val < right subtree
```

This lets us determine exactly which direction to move:
• if both targets < current node -> go left
• if both targets > current node -> go right
• otherwise -> we've found the split point -> this node is the LCA

# Why It Works
1. BST ordering ensures all smaller values are left, larger values are right
2. If p and q are on the **same side**, the LCA must be deeper on that side
3. If they are on **different sides**, current node is the first point where paths diverge -> LCA
4. If one equals root, LCA is root (a node is its own ancestor)
5. Only a single path is explored -> optimal time

# Complexities
Time: O(h)
• h = tree height
• Worst-case O(n) - skewed tree
• Best case O(log n) balanced BST

Space: O(h) recursion stack
(or O(1) if iterative)

# What I Learned
• BST structure makes LCA much simpler than general binary trees
• LCA is the first node where p and q fall on different sides
• Comparing only values is enough - no need to traverse both subtrees
• Classical decision pattern:
```java
if both < root -> go left
if both > root -> go right
else root is LCA
```

# Mistakes to avoid
- Treating it like a normal binary tree
- Forgetting that a node can be the ancestor of itself
- Mixing up the comparison logic (< vs >)
- Using BFS/DFS unnecessarily
