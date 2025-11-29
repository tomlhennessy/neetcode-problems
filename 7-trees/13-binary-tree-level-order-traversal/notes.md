# Problem Restate
Return a list of lists where each inner list contains the node values for one tree level, from **left to right**, starting from the root and progressing **level by level**.

This is a classic **Breadth First Search** problem.

# Key Design Question
How can we visit nodes **level-by-level**, ensuring all nodes on the same depth are grouped together?

Use a **queue like structure** (deque) to perform BFS
1. Push root into the queue
2. For each iteration:
  - measure queue size = number of nodes at current level
  - process exactly that many nodes
  - add their children for the next level
3. Append the collected level to the result

# Why It Works
1. BFS processes nodes in **FIFO** order
2. Using:
```java
addLast()       // enqueue
removeFirst()   // dequeue
```
turns a deque into a true queue

4. size = queue.size() locks in how many nodes belong to the current level
5. Children are enqueued in left->right order, preserving the correct traversal
6. All nodes are visited once -> O(n) time

# Complexities
Time: O(n)
Each node is enqueued and dequeued once

Space: O(n)
Queue can hold up to one full level of nodes

# What I Learned
• Level-order traversal = BFS, not DFS
• Use a queue (Deque) to process nodes FIFO
• Capturing size at each iteration isolates each level cleanly
• Append children while doing the level traversal -> next iteration handles next level
• Returning an empty list for a null root avoids null checks downstream

# Mistakes to Avoid
• Adding node instead of node.val
• Forgetting to group nodes by levels
• Returning null instead of an empty list for empty trees
• Enqueueing left/right children in reverse order


