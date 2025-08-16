# Problem Restate:
return true if input string is valid. string is valid when each opening bracket has a complementing closing bracket, in the correct order.

# Key Design question:
Use a stack to match closers to the **most recent** opener. Push expected closers to simplify checks

# Complexities:
Time complexity: O(n) each char pushed/popped at most once
Space complexity: O(n) worst case (all opens on stack)

# What I learned:
- Iterate through a String with `for (char c : s.toCharArray())`
- Use `.equals()` for Strings; chars compare with `==`

# Mistakes Made:
- Skipping the final `stack.isEmpty()` check
