# Problem Restate:
Find the max possible area of water that can be stored between two bars to form a container.

# Key Design question:
Height is limited by the shorter bar. Width is the distance between the two bars.
Using left and right pointers avoids redundant comparisons and maximises area efficiently

# Complexities:
time complexity: O(n)
space complexity: O(1)

# What I learned:
Since the shorter bar is the limiting factor on height, to potentially increase the area, we must move past it in the hopes of finding a taller bar.

# Mistakes Made:
