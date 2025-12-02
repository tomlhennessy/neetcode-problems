# Problem Restate
Return the list of node values visible from the **right side** of a binary tree.
These are the **rightmost nodes** at each depth, reported from top to bottom.

# Key Design Question
How can we extract the **last node at each level** of a binary tree?

Use **BFS level order traversal**:
• Process the tree level by level
• At each level, the **last node popped** from the queue is the rightmost node
• Append its value to the result list

# Why It Works
1. BFS guarantees all nodes at the same depth are processed together.
2. The queue order preserves left -> right child processing within a level
3. For a level with size nodes:
  • The node processed when i == size - 1 is the **rightmost** node
4. Collecting only that node gives the exact right-side view
5. Because each node is visited once, this is optimal O(n)

# Complexities
Time: O(n)
Every node enters and leaves the queue exactly once.

Space: O(n)
The queue may hold up one full level of the tree

# What I Learned
- Right side view = **last node at each BFS level**
- Use a Deque with addLast() and removeFirst() for clean FIFO BFS
- Capture size = queue.size() before looping to isolate one level
- Children are enqueued left->right, ensuring correct rightmost ordering
- Returning an empty list for null root makes the function robust

# Mistakes to Avoid
- Forgetting to call queue.isEmpty() with parentheses
- Adding entire level instead of just the rightmost node
- Mixing value and node-level operations (always add node.val)
