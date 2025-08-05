# Problem Restate:
Rotate an array by `k` steps

# Key Design question:
Create helper function to reverse array/subarray.

# Complexities:
time complexity: O(n)
space complexity: O(1)

# What I learned:
Can reverse parts of the array to rotate it in place
1. Reverse whole array
2. Reverse first `k` elements (originally last `k` elements, now at the front)
3. Reverse remaining elements

# Mistakes Made:
- Off by one errors when selecting left and right pointers
