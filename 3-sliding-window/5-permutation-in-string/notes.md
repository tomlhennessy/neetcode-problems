# Problem Restate:
Return true if first string is a permutation in the second string.

# Key Design question:
Use int[] to store char frequencies. Use a helper function to compare frequencies in s1 and window of s2.

# Complexities:
time complexity: O(n), we slide the window once through `s2` and each compare is O(26) constant time
space complexity: O(1), the frequency arrays are fixed size, independent of length

# What I learned:
- cache repeated values (`n = s2.length()`)
- make constraints explicit (ALPHABET) to avoid magic numbers
- keep helpers pure and tiny (`same` is good)
- if performance becomes critical, move to a `matches` counter to avoid the O(26) array compare each slide

# Mistakes Made:
- forgetting to use `s1.charAt(i) - 'a'` to get ASCII value
