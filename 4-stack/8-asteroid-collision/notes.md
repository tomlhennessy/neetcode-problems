# Problem Restate:
Given `int[] asteroids` where sign = direction (`>0` right, `<0` left) and `|x|` = size, simulate collisions and return final state (order preserved). Collide only when a right-mover meets a left-mover

# Key Design question:
Use a **stack of survivors**:
- iterate `a` in asteroids
- **while** a collision is possible, resolve:
  • top explodes
  • both explode
  • a explodes
- If `a` still alive, `st.push(a)`
- Build result by popping into array from right to left

# Complexities:
- **Time**: O(n) - each asteroid is pushed/popped at most once (amortized)
- **Space**: O(n) - worst case all asteroids survive on stack

# What I learned:
- Collisions happen if (right on stack) && (current is left)
- Use a `while` to handle chain reactions
- Compare sizes **via absolute value**
- Preserve original left->right order by **filling the result array from the end** when popping stack

# Mistakes Made:
- tried res.add(...), arrays don't have .add, must assign with `res[i] = ...`
- forgetting to return res after building
- using `if` (single clash) instead of `while` (chain collisions)
- checking collision when directions don't meet.
