# Problem Restate:
Return the integers in the nums array that account for more than a third of the array

# Key Design question:
There can only ever be a max of two candidates as together they would make up over two thirds of the array. We can select the majority candidates and then validate their count using an extension of Boyer-Moore's voting algorithm.

# Complexities:
time complexity: O(n)
space complexity: O(1)

# What I learned:
- Integer must be used for null types and `.equals` can be used as a safer option than `==`

# Mistakes Made:
- forgetting to do null checks
- forgetting to reset to `count = 1` when selecting a new candidate
