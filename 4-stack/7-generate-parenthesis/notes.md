# Problem Restate:
Return all **well-formed** parentheses strings using exactly `n` pairs

# Key Design question:
Use **backtracking (dfs)** with counts and an invariant:
- State: `open` used, `close` used, `sb` (current), res.
- Guards:
  • `open < n` -> may add `'('`
  • `close < open` -> may add `')'`
- Base: when `sb.length() == 2 * n`, add to `res`

# Complexities:
- **Time**: O(𝐶𝑛⋅n) (you emit 𝐶𝑛 strings of length 2n)
- **Space**:
  Aux (call stack + builder): 𝑂(n)
  Including output: 𝑂(𝐶𝑛⋅n)

# What I learned:
- Backtracking = **choose** -> **explore** -> **unchoose** with tight invariants
- Valid-prefix pruning: enforce `close < open` and `open <= n` to avoid dead paths
- `StringBuilder` + undo (`deleteCharAt`) keeps it O(1) per step.
- Count of results is the **Catalan** number

# Mistakes Made:
- forgetting to `undo` after recursion
- usign `<=` for `close` guard instead of strict `<`
