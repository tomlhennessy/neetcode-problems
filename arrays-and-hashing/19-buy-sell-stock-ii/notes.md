# Problem Restate:
Given an array of prices, find the maximum amount of profit you can make buy buying and selling at a given price on any number of days.

# Key Design question:
We are allowed unlimited buys/sells so we can use a greedy algorithm.

# Complexities:
time complexity: O(n)
space complexity: O(1)

# What I learned:
The greedy algorithm works because unlimited transactions are allowed. There is no reason to wait for a more optimal result. So each time, we always choose the best local result.

# Mistakes Made:
- forgetting to set `i < prices.length - 1` to prevent the loop from going out of bounds
