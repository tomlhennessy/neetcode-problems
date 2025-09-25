# Problem Restate
Count how many **contiguous** subarrays have some exactly `k`

# Key Design
Negatives allowed => sliding window fails. Use **prefix sums** + **hashmap of frequencies**
- Let `pref[i]` be the sum of `nums[0..i]`
- A subarray `i..j` has sum `k` if: `pref[j] - pref[i-1] = k` => `pref[i-1] = pref[j] - k`
- While scanning, keep a map `freq` of seen prefix sums:
  • `count += freq.getOrDefault(currSum - k, 0)`
  • `freq[currSum]++`
- Seed: `freq[0] = 1` (so subarrays starting at index `0` are counted)

# Complexities
Time: O(n)
Space: O(n) hashmap of prefix sums

# What I learned
- The order matters: check `sum - k` before inserting `sum`
- `freq[0]=1` is the empty-prefix trick to count subarrays from index 0
- Prefix differences handle negatives cleanly; two-pointers do not

# Mistakes to Avoid
- Forgetting the seed `freq.put(0,1)`
- confusing contiguous subarrays with subsequences
