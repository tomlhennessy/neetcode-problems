# Problem Restate
A node is **good** if no value on the path from the root to that node is **greater** than the node's value
Return the number of good nodes.

# Key Design Question
How can we track the **maximum value seen so far** on the path from the root to the current node?

Use DFS and carry along a parameter:
```java
maxSoFar = maximum value on the path from root -> parent
```

At each node:
• If node.val >= maxSoFar, it's **good**
• Update the max before recursing:
```java
newMax = Math.max(maxSoFar, node.val)
```

# Why It Works
1. Each path from root to a node has a **well-defined maximum**
2. A node is good if its value is >= this max
3. DFS naturally explores every root-to-node path
4. Passing maxSoFar downward ensures each node is evaluated using only its ancestors
5. Integer.MIN_VALUE ensures the root always counts as good without special cases

This eliminates extra structures - only recursion state is needed

# Complexities
Time: O(n)
Each node is visited exactly once

Space: O(h)
h = tree height (worst O(n), best O(log n) for balanced trees)

# What I Learned
- Path-based properties are solved by **carrying state** through DFS parameters
- Good nodes depend on **ancestor comparisons**, not siblings or descendants
- Start DFS with the smallest possible integer to ensure the root is always good
- The count accumulates naturally as part of the recursion

# Mistakes to Avoid
- Forgetting to update maxSoFar before recursing
- Trying to use global variables unnecessarily
- Recomputing max along the path instead of passing it down
