# Problem Restate
Insert a new value into a Binary Search Tree (BST) while maintaining the BST property.
Return the root of the updated tree.

# Key Design Question
How can we find the correct insertion point **using only BST ordering?**

Use simple recursion:
- Move **left** if val < root.val
- Move **right** if val > root.val
- When you reach a null child -> insert the new node there

# Why It Works
1. BST property guarantees the correct location for val is found by following comparisons
2. Recursion naturally descends until it finds a null child slot
3. At that slot we create:
```java
new TreeNode(val)
```
4. On the way back up, recursive calls reconnect parent pointers (root.left or root.right)
5. Final returned root preserves the original structure except for one new leaf

The insertion path is deterministic (only one possible direction at each step)

# Complexities
Time: O(h)
• h = height of the tree
• worst case O(n) if skewed
• best case O(log n) if balanced

Space: O(h) recursion stack
(same reasoning as time)

Iterative version can reduce space to O(1)

# What I Learned
• Insertion follows the search path defined by BST ordering
• Base case (root == null) is where the new node is added
• Recursive assignments like:
```java
root.left = InsertIntoBST(root.left, val);
```
  ensure the tree is reconnected correctly

Returning root is essential to preserve structure

# Mistakes to Avoid
• Forgetting to return the newly created node when root == null
• Typo in method name during recursive calls (very easy bug)
• Using >= or <= comparisons (values are guaranteed unique)
• Forgetting to reassign:
  • root.left = ...
  • root.right = ...
