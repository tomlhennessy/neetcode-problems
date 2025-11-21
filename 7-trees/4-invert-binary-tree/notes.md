# Problem Restate
Given the root of a binary tree, return the **inverted** tree, where every node's left and right children are swapped.
i.e. perform a **mirror transformation** of the entire tree.

# Key Design Question
How can we invert the entire tree **using recursion** in a clean, minimal way?

Use a simple recursive pattern:
1. Invert the left subtree
2. Invert the right subtree
3. Swap them on the current node

# Why It Works
1. Recursion naturally descends to leaf nodes
2. When recursion returns, each subtree is **already inverted**
3. Swapping at every node builds the mirror image
4. Base case stops recursion when a child is null.
5. The work happens on the way **back up** the tree:
recursion inverts subtrees -> final step swaps pointers

# Complexities
Time: O(n) - every node is visited once
Space: O(h) - recursion stack height
Worst case: O(n) for a skewed tree, best case O(log n) balanced tree

# What I Learned
- Inversion is just recursive subtree inversion + one swap
- Swap **after** recursion to ensure both children are already processed
- Returning root allows recursion to rebuild connections cleanly
- Base case is simple: if (root == null) return null;

# Mistakes to Avoid
- Swapping **before** recursion (causes recursion to walk the wrong branches)
- Forgetting the base case -> infinite recursion
- Adding unnecessary temp structures (no need for queues, stacks, lists)
- Overcomplicating: the entire solution is only a few lines
