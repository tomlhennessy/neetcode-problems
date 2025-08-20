# Problem Restate:
Evaluate an arithmetic expression given in Reverse Polish Notation. Return an int. Division truncates towards zero.

# Key Design question:
Use a **stack**:
  For each token:
    - **number** -> push integer
    - **operator** -> pop `left`, pop `right`, compute `l` op `r` and push result

# Complexities:
- **Time**: O(n) single pass, each token processed once
- **Space**: O(n) worst case all numbers on stack

# What I learned:
- Operand order matters: pop right then left
- Java Integer `/` already truncates towards 0
- New `switch` style on strings is concise and avoids `.equals` pitfalls


# Mistakes Made:
- Using `==` for comparison instead of `switch`/`.equals()`
- Pushing raw string token instead of `Integer.parseInt(token)`
- Forgetting the final return `peek()`
