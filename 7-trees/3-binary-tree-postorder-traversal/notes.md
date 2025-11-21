# Problem Restate
Return a postorder traversal of a binary tree in **left -> right -> node** using an **iterative** approach

# Key Design Question
How can we produce postorder order **without** simulating recursion directly?

Generate a modified preorder sequence:
```css
node -> right -> left
```

Then reverse it at the end to obtain true postorder:
```css
left -> right -> node
```

# Why It Works
1. Postorder is `L R N`
2. Reverse it -> `N R L`
3. Use a stack to generate `N R L`:
  - Pop a node -> add to result immediately
  - Push children so that right is processed first
  ```java
  push(left)
  push(right)
  ```
4. Reverse the collected list -> becomes correct postorder

This avoids extra data structures or visited flags - just one pass + one reverse

# Complexities
Time: O(n) each node is pushed and popped once
Space: O(n) Worst-case stack usage in a skewed tree

# What I Learned
- Postorder can be created by reversing a modified preorder
- Correct push order matters: **push left first, then right**
- Aim to generate `N R L` (node -> right -> left), then reverse to get `L R N`
- Stack behaviour (LIFO) dictates traversal order - control it intentionally

# Mistakes to Avoid
- Pushing right before left (breaks the required pop order)
- Forgetting to reverse the result
- Trying to replicate recursion with complext state
- Mixing it up with standard preorder push logic
