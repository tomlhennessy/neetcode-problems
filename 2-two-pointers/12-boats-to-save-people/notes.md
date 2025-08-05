# Problem Restate:
Find the minimum amount of boats to transport all people, where all people fit into the boat weight limit.

# Key Design question:
Greedy and two-pointer solution.
Always assign one boat per iteration.
If the lightest + heaviest fit, pair them.
If not, send the heavier one alone.

# Complexities:
time complexity: O(n log n) (due to sorting)
space complexity: O(1) solved in-place

# What I learned:
It's **greedy** because you're always making the **best local decision**: pair the lightest person with the heaviest who can still fit. 

# Mistakes Made:
