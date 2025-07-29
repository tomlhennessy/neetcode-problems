# Problem Restate:
Merge to strings into one, alternating between a character from each string.

# Key Design question:
Use a StringBuilder to solve in-place

# Complexities:
time complexity: O(n)
space complexity: O(1)

# What I learned:
- How to handle uneven lengths without overcomplicating
- StringBuilder is "mutable" -> appends and edits are fast and memory efficient.

# Mistakes Made:
- didnt account for either `i` or `j` being out of bounds exception.
