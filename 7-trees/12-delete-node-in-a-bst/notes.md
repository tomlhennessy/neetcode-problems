# Problem Restate
Given the root of a BST and a key, delete the node with that value (if it exists) and return the updated root.
The result must still be a valid BST

# Key Design Question
How do we delete a node in a BST **whilst preserving the BST ordering rules?**

Break it into two phases:
1. **Search** for the node using the BST property
2. **Delete** it by handling one of three structural cases:
  • 0 children (leaf)
  • 1 child
  • 2 children

# Why it Works

BST search phase:
• If key < root.val -> go left
• If key > root.val -> go right
• Else -> found the node to delete

Deletion cases:
1. No children
```java
return null;
```

2. One child
Bypass the node:
```java
return root.left // or root.right
```

3. Use the inorder successor (the minimum in right subtree):
  • It's the **smallest** value larger than the current node
  • Replacing root.val with this keeps BST in order
  Steps:
```java
curr = curr.right;
while (curr.left != null) {
  curr = curr.left;
}
root.val = curr.val;
root.right = deleteNode(root.right, curr.val);
```
This recursively removes the successor after copying its value

# Complexities
Time: O(h)
• h = height of tree
• worst-case: O(n) skewed, best-case: O(log n) (balanced)

Space: O(h) due to recursion
(can be made iterative for O(1) space)

# What I Learned
• BST deletion always reduces to exactly three structural cases
• The inorder successor ensure BST ordering stays valid
• Deleting the successor must happen **after** copying its value
• Returning root after modification reconnects the tree correctly
• Searching and deleting merge into one clean recursive function

# Mistakes to Avoid
- Stopping the inorder successor loop too late (must stop at curr.left == null)
- Confusing successor (min in right subtree) with predecessor (max in left)
- Forgetting to update pointers:
```java
root.left =
root.right =
```
- Forgetting to return root at the end of the function
