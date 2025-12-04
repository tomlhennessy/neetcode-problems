# Problem Restate
Given an n x n binary grid (values 0/1), build a **Quad Tree** where each node represents a square subregion of the grid.

A node is:
• **leaf** if its entire region contains the same value -> isLeaf = true, val = (that value)
• **internal** if the region contains mixed values -> isLeaf = false, and it has 4 children:
  - topLeft
  - topRight
  - bottomLeft
  - bottomRight

# Key Design Question
How do we recursively divide the grid into quadrants until each region is uniform?

Use one helper:
```java
Node build(grid, row, col, size)
```
It constructs a quad-tree node for the sub-square:
• Top-left coordinate: (row, col)
• Side length: size

Steps:
1. **Check if the region is uniform**
  - if yes, return a leaf node

2. **Otherwise, split into 4 equal squares**

3. Recursively build children

4. Return an internal node

# Why It Works
A quad tree always divides a square into 4 smaller squares of equal size until each square is **pure** (all 0s or all 1s)
This recursive subdivision matches the natural structure of Quad Trees:
• Uniform region -> stop
• Non-uniform -> subdivide into 4 children
• Each child is itself a smaller quad tree

size allows the algorithm to shrink the region
```java
size -> size/2 -> size/4 -> size/8 -> ... -> 1
```
Eventually, size = 1 ensures leaf nodes

# Complexities
Time: O(n^2)
Every grid cell is visited once per recursion level
Since Quad Trees subdivide into 4 parts each time and n <= 64, this is efficient

Space: O(n^2) worst-case recursion depth is O(log n), but storing tree nodes covers all subregions

# What I Learned
- Quad trees represent **recursive 2D partitioning**
- isUniform determines if a region becomes a lead or must split
- Splitting coordinates follows a fixed pattern
- Internal nodes don't require a meaningful val -> any boolean works
- Size drives recursive shrinking until uniformity or base case is reached

# Mistakes to avoid
- Forgetting size / 2 for each recursive subdivision
- Checking uniformity incorrectly (don't compare only edges; check entire region)
- Returning too early inside loops - ensure full region is scanned


# Core Pattern (to remember)
```java
if (region is uniform)
  return leaf
else
  build 4 children using (row, col, size/2)
  return internal node
```
