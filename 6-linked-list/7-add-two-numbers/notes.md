# Problem Restate
Add two non-negative integers represented by reverse-order linked lists and return the sum as a linked list.

# Key Design Question
How do we add digit-by-digit while handling carry and uneven list lengths?
-> Iterate both lists together, treat missing nodes as `0`, maintain a running `carry`

# Why it Works
- Reverse order means least significant digits come first, so we can add in one pass
- For each position: `total = x + y + carry`, `digit = total % 10`, `carry = total / 10`
- Loop continues while either list has nodes **or** there's a remaining `carry`

# Core Pattern
- Use a **dummy head** and a moving **tail** to append results cleanly
- Read `x` and `y` as 0 when a list runs out
- Append `digit` each step; update carry

# Complexities
• Time: O(m + n)
• Space: O(1) extra (output list excluded)

# What I Learned
- Dummy head simplifies first-node insertion
- Treat null nodes as `0` avoids branching explosion
- Keep the loop condition `while (p != null || q != null || carry > 0)` to capture a final carry

# Mistakes to Avoid
- Forgetting the last carry
- Advancing `p`/`q` without null checks
