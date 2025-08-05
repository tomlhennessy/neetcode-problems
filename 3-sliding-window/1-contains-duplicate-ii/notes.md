# Problem Restate:
Return true if nums contains duplicates within k range.

# Key Design question:
Sliding window and HashSet.
Before inserting `nums[i]`, check if its already in the set.
After inserting, if window size > k, remove num at nums[i - k].

# Complexities:
time complexity: O(n)
space complexity: O(k)

# What I learned:
Sliding window size is often **fixed** or **bounded**, whereas two pointers is often **dynamic**.
Sliding window is used to track content of a recent range (window), whereas two pointers is for comparing/merging data between two ends

# Mistakes Made:
- Forgetting to add number to sliding window
- Use `.size()` for HashMaps, not .length
