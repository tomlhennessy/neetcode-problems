# Problem Restate:
Return a list of triplets such that the three values sum up to 0. No duplicates allowed.

# Key Design question:
Sort first. Outer loop picks `nums[i]`. Inner loop finds pairs that sum to `-nums[i]`. Duplicates skipped cleanly using sorted order.

# Complexities:
time complexity: O(n^2)
space complexity: O(1)

# What I learned:
Sorting lets us use a two pointer scan like in Two Sum ii.
It also makes duplicate skipping easy -> just check `nums[i] == nums[i - 1]`.
Use `Arrays.asList` as java doesn't support array list style literals

# Mistakes Made:
- Duplicate skipping should only run after a valid triplet is found
- forgetting continue block for skipping duplicates in outer loop
