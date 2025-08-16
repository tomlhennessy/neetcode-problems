# Problem Restate:
Process a list of ops over a score stack. Return the running total.

# Key Design question:
Use a stack (LIFO) because every op touches the most recent scores.

# Complexities:
Time complexity: O(n)
Space complexity: O(n)

# What I learned:
- Maintain a running sum to avoid a second pass
- in Java `ArrayDeque` > `Stack` for single-threaded performance
- prefer stack ops `(pop/peek/push)` - constant extra space
- String comparison in Java: use `.equals()`

# Mistakes Made:
- Used `==` for String compare
