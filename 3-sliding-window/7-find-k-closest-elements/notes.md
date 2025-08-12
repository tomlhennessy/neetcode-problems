# Problem Restate:
Given a sorted array, return `k` integers closest to `x`. Closer means smaller absolute distance. Ties go to smaller numbers

# Key Design question:
Use binary search on the left index of the window, comparing the two edge elements of competing windows.

> Slide start index until left edge is no longer further than right edge. thats `lo`.

# Complexities:
time complexity: O(log(n - k) + k)
  -> O(log(n - k)) to find start index, O(k) to build result
space complexity: O(k) for result list

# What I learned:
- Sorted array + fixed window length lets you compare **only the two edges** to decide which way to move in binary search
- No need for `Math.abs` because sorted order guarantees sign of differences
- Two pointer shrink method is simpler but slower (O(n) - k)

# Mistakes Made:
- Off by one in window size calculation
- calculating mid offset instead of index, should be `lo + (hi - lo) / 2`
