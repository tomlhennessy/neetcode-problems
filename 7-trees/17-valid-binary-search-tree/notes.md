# Problem Restate
Given the root of a binary tree, return true if it is a **valid Binary Search Tree (BST), otherwise false**.

A valid BST must satisfy for **every node**:
- All values in the **left subtree** are **strictly less** than node.val
- All values in the **right subtree** are **strictly greater** than node.val
- Both left and right subtrees are themselves valid BSTs

# Key Design Question
How can we ensure every node respects **all ancestor constraints**, not just its parent?

Use DFS with value bounds (min, max):
```java
dfs(node, min, max)
```

At each node, enforce:
```java
min < node.val < max
```

Then:
• Left child must be in range (min, node.val)
• Right child must be in range (node.val, max)

Use long for min and max to avoid int overflow and handle edge values safely


# Why It Works

1. Each node is constrained by **all its ancestors** via the (min, max) bounds
2. For root, we start with the widest possible range:
  ```java
  Long.MIN_VALUE < root.val < Long.MAX_VALUE
  ```
3. Going left:
  - All values must be < node.val -> new range: (min, node.val)

4. Going right:
  - All values must be > node.val -> new range: (node.val, max)

5. If any node violates min < val < max, the BST property is broken and we return false


# Complexities

Time: O(n)
Every node is visited exactly once

Space: O(h) recursion stack
• h = tree height
• worst-case O(n) (skewed tree), best case O(log n) (balanced)


# What I Learned
- Valid BST requires global constraints per node, not just local
- Passing (min, max) down the recursion enforces these global constraints
- Strict comparisons (<, >) are required, duplicates are not allowed

# Mistakes to avoid
- Allowing >= or <= (BST requires strictly less / strictly greater)
- Forgetting to update the correct bound
