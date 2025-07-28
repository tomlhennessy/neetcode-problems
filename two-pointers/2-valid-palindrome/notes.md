# Problem Restate:
Is the string a valid palindrome (reverse of string is equal to string)

# Key Design question:
Set two pointers that match characters and skip non characters

# Complexities:
time complexity: O(n)
space complexity: O(1)

# What I learned:
Non-primitive types like String and Character have useful methods i.e. `isLetterOrDigit`, `charAt`

# Mistakes Made:
- forgetting to convert to lowercase - comparisons like `A` != 'a' will fail
- missing `continue` or `else` blocks - even when skipping, the comparison still runs
- missing `left++` and `right--` after a successful comparison - pointers get stuck
