# Problem Restate
Return true if a binary tree is **height-balanced**, meaning at every node:
```java
Math.abs(height(leftSubtree) - height(rightSubtree)) <= 1
```
Otherwise return false

# Key Design Question
How can we check balance at every node **without** recomputing heights repeatedly?

Use a bottom-up DFS that returns:
- the height of a subtree if it is balanced
- -1 if the subtree is **unbalanced**

Any -1 immediately propogates upward, pruning extra work

# Why It Works
1. Height of a node depends only on:
```java
1 + max(height(left), height(right))
```

2. A node is unbalanced if:
```java
Math.abs(leftHeight - rightHeight) > 1
```

3. If either subtree is unbalanced, the whole tree is unbalanced -> return -1

4. Returning -1 instead of a boolean allows:
  - Single DFS pass
  - No repeated height computation
  - Early exit on failure

5. Final answer is simply:
```java
dfs(root) != -1
```

# Complexities
Time: O(n)
Each node visited once

Space: O(h) recursion stack
Worst-case O(n) skewed tree, best case O(log n) balanced tree

# What I Learned
- Balance must hold at every node, not just the root
- Best pattern: "return height or -1" during DFS
- A bottom up approach avoids expensive repeated height calculations
- -1 is a clean sentinel because valid heights are always >= 0

# Mistakes to Avoid
- Forgetting to use `node == null` as base case
- Returning booleans from the DFS - leads to redundant height recomputation
- Checking only the root's height difference
- Not handling early propogation of unbalance (-1)
