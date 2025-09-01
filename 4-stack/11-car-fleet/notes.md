# Problem Restate:
Given target, position and speeds for n cars on a one-lane road, count how many fleets reach the target. A fleet is a group that ends up at the same position moving at the same speed; a car that catches another (even exactly at the target) becomes part of that fleet

# Key Design question:
How to decide merges **without simulating movement?**
- Compute each car's **time to target**: `time = (target - position[i]) / speed[i]` (as `double`)
- Sort by position descending (closest -> furthest)
- Sweep once while tracking the **slowest time so far** ahead:
  • if current `time > slowest`, it can't catch the car(s) ahead -> **new fleet**, update `slowest` time
  • else it merges into the fleet ahead

# Complexities:
- **Time**: O(n log n) for sorting + O(n) sweep -> O(n log n) overall
- **Space**: O(n) for storing `(position, time)` pairs (can be reduced with indices but still O(n))

# What I learned:
- The order to process matters: handle cars closest to target first
- Use **time-to-target** as the comparison key
- Avoid integer division - use `double` to keep times accurate

# Mistakes Made:
- Sorting ascending by position (breaks the greedy logic)
- Using integer division for time (truncates, yields wrong merges)
- Using `>=` instead of `>` (incorrectly splits fleets that meet at the destination)
