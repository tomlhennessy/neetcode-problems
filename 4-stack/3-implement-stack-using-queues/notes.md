# Problem Restate:
Implement a stack using only queue operations.

# Key Design question:
- Use two queues to simulate LIFO
- Make `push()` reorder elements so `pop()` and `top()` remain O(1)

# Complexities:
`Push()`: O(n)
`pop()`: O(1)
`top`: O(1)
Space: O(n)

# What I learned:
- Swapping queues avoids costly element moves in `pop()`
- Queue's `offer()`, `poll()`, and `peek()`are the standard operations to respect constraints

# Mistakes Made:
- Forgetting to swap `q1` and `q2` after `push()`
