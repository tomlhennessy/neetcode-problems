# Problem Restate:
Decode strings of the form `k[encoded]` where `encoded` can nest. Repeat `encoded` `k` times and concatenate

# Key Design question:
How to handle nesting without recursion?

- Scan left->right with two stacks:
  • `counts` for repeat numbers
  • `strings` for previously built strings
- State: `k` (current number), `cur` (current built string)
- On digit: `k = k * 10 + (ch - '0')`
- On `'['`: push `k` and `cur`
- On `']'`: pop `time` and `prev`, append `cur` repeated `times` to `prev`, set `cur = prev`
- On letter: `cur.append(ch)`

# Complexities:
- **Time**: O(n) to scan + cost proportional to final output size
- **Space**: O(n) in worst case for stacks and builders

# What I learned:
- Use two stacks to snapshot `repeat count` and `previous string` at each `'['`
- Accumulate multi digit numbers with `k = k * 10 + (ch - '0')`
- `StringBuilder` is key for efficient appends

# Mistakes Made:
- Forgetting to reset `k` and `cur` after `'['`
- Using prev += cur instead of `prev.append(...)`
