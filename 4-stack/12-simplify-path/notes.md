# Problem Restate:
Given an absolute unix path, produce its **canonical** form:
- collapse multiple `/` into one
- `.` means stay (ignore)
- `..` means go up one dir (if possible)
- anything else is a normal name

# Key Design question:
How do we rebuild the path without reversing?
- Split on `/`
- Use a deque as a stack of directory names
- process each token
- join with slash

# Complexities:
- **Time**: O(n) where `n = path.length()`
- **Space**: O(k) for at most `k` directory tokens on stack

# What I learned:
- Compare Strings with `.equals`
- Deque can act as a stack at either end:
  • `addLast`/`removeLast` keeps left->right order for `String.join`
  • `push`/`pop` is fine, but then join in reverse
- tokens from `split("/")` include `""` for repeated slashes, never `"/"`

# Mistakes Made:
- Pushing with `push` then using `String.join()` (order reversed) without using descending iterator
- Returning `"/" + join` without guarding empty stack (should return just `"/"`)
