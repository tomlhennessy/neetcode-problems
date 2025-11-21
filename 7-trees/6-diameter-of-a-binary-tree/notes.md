# Problem Restate
Return the **diameter** of a binary tree:
The length (in edges) of the longest path between **any two nodes** in the tree.
The path does **not** need to pass through the root.

# Key Design Question
How can we compute the longest path between any two nodes **using depth**?

At each node, the longest path **through** that node is:
leftDepth + rightDepth

So the diameter is the **maximum** of this value across all nodes

# Why It Works
1. Depth gives us the longest root->leaf path in each subtree
2. For any node:
  - the best path through it = deepest left + deepest-right
3. By computing depth recursively, we naturally visit every node.
4. While recursing, we update a **global maxDiameter**:
```java
maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
```
5. The recursion returns depth upward, but updates diameter as a side effect.

This allows computing both depth and diameter in a single DFS.

# Complexities
Time: O(n)
Every node is visited once

Space: O(h) recursion stack
Worst case O(n) for skewed tree, best case O(log n) for balanced

# What I Learned
- Diameter uses depth - each node's depth helps compute a candidate diameter
- Depth is returned upward; diameter is tracked seperately (global field)
- Diameter counts **edges** not nodes
- The answer at the root is not necessarily the best; the best can be anywhere.

# Mistakes to Avoid
- Mixing up edges vs nodes (diameter = leftDepth + rightDepth)
- Forgetting to track a **global maximum**
- Returning diameter instead of the depth inside DFS

