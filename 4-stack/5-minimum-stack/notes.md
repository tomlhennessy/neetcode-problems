# Problem Restate:
Design a **stack** supporting `push`, `pop`, `top`, `getMin`, all in O(1) time.

# Key Design question:
Maintain **two stacks**:
- **vals**: holds all pushed values
- **mins**: at each depth, stores the **minimum so far** up to that index

# Complexities:
- **Time**: O(1) per op
- **Space**: O(n) mins mirrors vals

# What I learned:
- O(1) `getMin` needs **extra state** tracking the running minimum at each depth.

# Mistakes Made:
- Forgetting to pop both stacks
