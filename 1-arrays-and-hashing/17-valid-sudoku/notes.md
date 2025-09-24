# Problem Restate
Check a 9x9 board is **valid** (not necessary solvable/complete):
- Rows contain 1-9 without duplicates
- Columns contain 1-9 without duplicates
- Each 3x3 subbox contains 1-9 without duplicates
- Dots `'.'` are blanks and ignored

# Key Design Question
How to detect duplicates across rows, columns and 3x3 boxes in one pass?
- Maintain 3 trackers:
  • `rows[9]`, `cols[9]`, `boxes[9]` (each a `Set<Character>` or Boolean bitmask)
- For each cell `(r, c)` with digit `ch`:
  • Compute box index: `b = (r / 3) * 3 + (c / 3)`
  • If `ch` already in `rows[r]` or `cols[c]` or `boxes[b]` -> invalid
  • Else add to all three

# Box Index Formula (why it works)
- `r / 3` selects the row band (0..2), `c / 3` selects the column band (0..2)
- There are 3 boxes per "box-row" -> `box = 3 * (r/3) + (c/3)`

# Complexities
Time: O(81) = O(1) (fixed 9x9 board)
Space: O(1) (three arrays of 9 sets/bitmasks)

# What I Learned
- One-check pass with parallel trackers is simpler than seperate row/col/box scans
- Treat blanks as "skip"; only digits participate in duplicate checks
- Box mapping via integer division removes need for a triple loop

# Mistakes to avoid
- Using `"."` (string) instead of `'.'` (char)
- Forgetting the box index formula or miscomputing it
- Multiple passes when one suffices
