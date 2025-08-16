# Problem Restate:
Build a FIFO queue with **two LIFO stacks** supporting: `push`, `pop`, `peek`, `empty`. Aim for **amortized O(1)** per op.

# Key Design question:
Maintain two stacks:
- **in**: receive all pushes
- **out**: serve pops/peeks
rule: When `out` is empty, move all items from `in` -> `out` (reverses order so oldest is on top of `out`)

# Complexities:
Time: (amortized): O(1) per op
(Each element moves `in -> out` at most once before being popped)
Space: O(n)

# What I learned:
- Amortization trick: do the expensive transfer only when needed
- FIFO via two LIFOS reversing once
- Can keep API clean with small helper:
```java
private void shift() {
  if (out.isEmpty()) while (!in.isEmpty() out.push(in.pop()));
}
```

# Mistakes Made:
- Transferring on every pop/peek (kills amortization)
- Forgetting to check `out.isEmpty()` before `pop/peek`
