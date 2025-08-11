# Problem Restate:
Find the length of the longest substring of unique chars.

# Key Design question:
Use a HashSet to check for duplicates.
Use a sliding window to keep track of substring

# Complexities:
time complexity: O(n)
space complexity: O(1)

# What I learned:
You can't directly access indexed chars in a string as it's not an array

# Mistakes Made:
- Use `s.charAt(i)` instead of `s[i]`
- Use `Set<Character>` (not `Set<Integer>`)
- Clarify what `j` represents (left of the window)
