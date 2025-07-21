# Problem Restate:
Find the longest sequence of consecutive numbers in the nums array.

# Key Design question:
Use a HashSet to lookup values in O(1) time. Iterate through the numbers and find the beginning of a sequence. Keep track of the length of the sequence and compare it with the max length of a sequence found so far.

# Complexities:
Time: O(n) complexity
Space O(n) complexity

# What I learned:
I learned how to find the start of a sequence, as well as how to track the length of a sequence.

# Mistakes Made:
- initialising length (should be 1) and current (should be num)
- looping through n as an index instead of looping over the actual nums
