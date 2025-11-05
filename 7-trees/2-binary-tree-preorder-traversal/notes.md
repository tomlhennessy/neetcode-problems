# Problem Restate
Given the root of a binary tree, return its **preorder traversal** (Node -> Left -> Right)

# Key Design Question
How can we traverse the tree iteratively without recursion, while preserving preorder order?
-> Use a **stack** to simulate recurison:
1) Visit the node (add value)
2) Push the node to remember to visit its right child later
3) Move left until null, then pop to continue right

# Why it Works
Preorder means each node is processed as soon as we reach it.
The stack stores ancestors whose right subtrees are not yet explored.
When we can't go left anymore, we backtrack by popping the last node and exploring its right side

# Complexities
Time: O(n) - every node visited once
Space: O(h) - height of tree (stack stores path from root to current)

# What I Learned
- Preorder is the simplest DFS traversal to reason about iteratively
- Use stack to replace recursion
- Visit node first -> dive left -> pop -> go right

# Mistakes to Avoid
- Forgetting to add the root value before descending left
- Pushing nulls onto the stack
- Confusing inorder vs preorder: preorder visits **before** recursion
