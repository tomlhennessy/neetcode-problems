# Problem Restate
Given two binary trees, return true if and only if they have:
1. The same structure
2. The same node value in every corresponding position

Otherwise return false.

# Key Design Question
How can we compare two trees by recursively checking their structure and values in **lockstep**?

Use a simple DFS:
- If both nodes are null -> same
- If exactly one is null -> different
- If both non-null -> check:
  • values match
  • left subtrees match
  • right subtrees match

# Why It Works
1. Structural equality is naturally checked by recursion:
  - A missing child vs a non-missing child returns false
2. Value equality ensures corresponding nodes hold the same integer
3. Recursing on both left and right ensures entire shape is matched
4. Because trees are finite, recursion completes in linear time
5. Final result is the AND of:
  - values match
  - left subtrees match
  - right subtrees match

# Complexities
Time: O(n) - Every node is visited once
Space: O(h) - recursion stack
Worst-case: O(n) for skewed tree, best case O(log n) for balanced

# What I Learned
- Tree equality requires checking both value and structure
- The base case determines correctness (null/null vs null/non-null)
- DFS mirrors the shape of the trees, making comparison natural
- Once a mismatch occurs (value or structure), recursion short-circuits

# Mistakes to Avoid
- Returning true when one child is null and the other is not
- Forgetting to check node values before recursing
- Using OR instead of AND in the final return
- Overcomplicating with queues/stacks - recursion is ideal here
