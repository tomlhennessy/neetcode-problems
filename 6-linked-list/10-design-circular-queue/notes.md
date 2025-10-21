# Problem Restate
Implement a **circular queue** (ring buffer) that support `enQueue`, `deQueue`, `front`, `rear`, `isFull`, `isEmpty` in O(1) time without using built-in queue classes

# Key Design Question
How do we track wrap-around positions efficiently?
-> Use a fixed-size array `head`, `size`, and `cap`

Compute all positions modulo `cap`:
- **Front**: `head`
- **Rear**: `(head + size - 1) % cap`
- **Next write**: `(head + size) % cap`

# Why It Works
- Storing only `head` and `size` avoids off-by-one edge cases
- Modulo indexing (% cap) wraps indexes automatically when they reach the array's end
- Each operation touches constant-time fields -> O(1) per call

# Complexities
Time: O(1) for all operations
Space: O(k) for array storage

# What I Learned
- "Circular" = wrap indexes via modulus
- Tracking `size` avoids needing a "blank slot" rule
- Queue logic stays clean with a `dummy`-like array of fixed capacity

# Mistakes to avoid
- Using `tail = size` instead of `(head + size) % cap`
- Forgetting to mod wrap `head` or `tail`
- Confusing `isFull` condition (`size == cap`) with `isEmpty` (`size == 0`)
