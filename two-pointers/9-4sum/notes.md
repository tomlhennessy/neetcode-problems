# Problem Restate:
Return array of all unique quadruplets that add up to the target. No duplicates

# Key Design question:
Two fixed indices (`nums[i]`, `nums[j]`) + two pointer scan (`nums[l]` + `nums[r]`).
Duplicate skips for `i`, `j`, `l`, `r` - clean and in the right spots


# Complexities:
time complexity: O(n^3) acceptable for `n <= 200`
space complexity: O(k + log n) where
- `k` is the number of valid quadruplets
- log n is from sorting

# What I learned:
Use Arrays.asList to build result quadruplets.
Use recursion for kSum but in this case O(n^3) is fine
Java method names can't start with a digit
Use `long` to prevent stack overflow for large numbers

# Mistakes Made:
- trying to get correct endpoints for loops
- missing guards for duplicate skips
- using `int` for sum when values exceeded int max limit (2.1B)
