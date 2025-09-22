# Problem Restate
Encode a list of strings into one string and decode it back, safely handling any characters.

# Key Design
Use a **length-prefix** per word:
`<len>#<word>`
- Encode: append `s.length()`, `#`, then `s`
- Decode: scan digits to `#` -> parse `len` -> take exactly `len` chars

# Decode Invariants
- `i` = start of length digits
- `j` = scans to the `#`
- `len = int(str.substring(i, j))`
- word = `str.substring(j + 1, j + 1 + len)`
- Next record starts at `i = j + 1 + len`

# Complexity
Time: O(total chars) for both encode and decode
Space: O(total chars) for outputs

# What I learned
- Length-prefix avoids delimiter-escaping: `#` inside words is safe
- Work with indices and half-open slices; be explicit about starts/ends
- Guard the inner scan `(while j < str.length() && str.charAt(j) != '#')`

# Common Mistakes
- Char literal (use `'#'`, not `#`)
- Copy bounds: use the correct start for the word `(j + 1)`, not `i`
