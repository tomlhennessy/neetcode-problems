# Problem Restate:
Find smallest length of window that sums up to the target from the nums array

# Key Design question:
Use a sliding window. Expand right to reach target. Shrink left to find minimum possible length

# Complexities:
time complexity: O(n) each element enters and leaves the window at most once.
space complexity: O(1) just variables, no extra data structures

# What I learned:
- Use `long` for the running sum to avoid overflow with large targets and values
- the inner `while` loop guarantees we record the **minimal** window ending at `right` before moving on.
- the `Integer.MAX_VALUE` sentinel + `0` return covers the "no valid subarray" case cleanly

# Mistakes Made:
- using `=` instead of `==`. Remember `=` is read as "assigned to"
