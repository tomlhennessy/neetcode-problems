# Problem Restate
Given the root of a binary tree, return a list of its node values in **inorder traversal**.
That is, visit nodes in the order **left -> root -> right**

# Key Design Question
How can we simulate recursion using an explicit stack to achieve **O(n)** traversal without recursive calls?

# Why It Works
In recursion, each call implicitly keeps track of:
• which node we're on
• which subtrees are yet to explore

Using a **stack** manually replaces that:
1. Push all left nodes (go deep left)
2. Pop when you reach null (visit that node)
3. Move to its right subtree

Repeat until both stack is empty and current node is null

# Algorithm
```java
List<Integer> res = new ArrayList<>();
Deque<TreeNode> stack = new ArrayDeque<>();
TreeNode curr = root;

while (curr != null || !stack.isEmpty()) {
  while (curr != null) {
    stack.push(curr);
    curr = curr.left;
  }

  TreeNode node = stack.pop();
  res.add(node.val);
  curr = node.right;
}

return res;
```

# Complexities
Time: O(n) - each node visited once
Space: O(h) - stack holds up to the tree height (worst case O(n))

# What I Learned
- Inorder = **left -> root -> right**
- Stack replaces the recursive call stack
- Each node is pushed once, popped once -> O(n) total

# Mistakes to Avoid
- Using `&&` instead of `||` in loop condition
- Forgetting to `curr = node.right` after visiting
- Returning before completing traversal
