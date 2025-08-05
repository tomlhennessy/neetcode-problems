# Problem Restate:
Given an array of integers, return the total number of subarrays that sum up to `k`.

# Key Design question:
We need to keep a track of prefix sums that can be taken away from the total sum to equal k. To do this we use a HashMap and store frequencies (i.e. how many times that previous sum has occured).

# Complexities:
time complexity: O(n)
space complexity: O(n) worst case (if all prefix sums are unique)

# What I learned:
A base case allows us to keep an accurate count of possible subarrays that sum to k.

# Mistakes Made:
- forgot to add the base case `{0, 1}` -> empty subarray sums to 0
