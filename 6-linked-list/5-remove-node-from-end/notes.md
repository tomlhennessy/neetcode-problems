# Problem Restate
Given the head of a linked list and an integer `n`, remove the **nth node from the end** and return the new head.

# Key Design Question
How can we know the nth node from the end without knowing the total length first?
-> Use **two pointers** spaced `n+1` apart so that when the first hits null, the second is right before the target.

# Why It Works
Maintaining a constant gap of `n+1` between `fast` and `slow` ensure that when `fast` reaches the end, `slow` is exactly **one node before** the one we want to remove.

The dummy node handles edge cases (like removing the head) cleanly, so we can safely do `slow.next = slow.next.next`

# Complexities
- Time: O(n) single traversal
- Space: O(1) only two pointers

# What I Learned
- Use a dummy node to simplify edge cases
- Maintain an **invariant gap** between `fast` and `slow`
- When `fast == null`, `slow` is positioned before the target
- Deleting a node is just: `slow.next = slow.next.next`

# Mistakes to Avoid
- Using only `n` steps instead of `n+1` - `slow` would land **on** the node instead of **before** it
- Forgetting to handle the head removal case (dummy fixes this)
- Stopping when `fast.next == null` - you'll overshoot by one
