# Problem Restate:
Return the maximum profit you can achieve buy buying once on one day and selling on another.

# Key Design question:
Track the **lowest price seen** so far. Calculate profit **only when** a higher price appears after it.
`minPrice` = best buying opportunity so far

# Complexities:
time complexity: O(n)
space complexity: O(1)

# What I learned:
Stock related problems generally mean `buy low`, `sell high`.
You can't go backwards in time, so you must find the lowest price **so far** as you scan from left to right.
maxProfit is updated greedily whenever we find a better deal.

# Mistakes Made:
