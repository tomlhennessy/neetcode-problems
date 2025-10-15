# Problem Restate
Given the head of a linked list where each node has `next` and `random`, create a **deep copy** so that no pointer in the new list references any original node.

# Key Design Question
How can we connect cloned nodes` `next` and `random` pointers when they may point anywhere?
-> Make a map from **original node** -> **cloned node** in pass 1, then wire pointers in pass 2 using that map.

# Why It Works
- After pass 1, every original node has a unique clone in the map
- In pass 2, `clone.next = map.get(orig.next)` and `clone.random = map.get(orig.random)` correctly translate original pointers to cloned pointers
- This guarantees a **true deep copy** with no cross-links to the original list

# Core Pattern (2 pass + map)
1. Clone nodes (values only): `map.put(orig, new Node(orig.val))`
2. Wire pointers:
  • `clone.next = map.get(orig.next)`
  • `clone.random = map.get(orig.random)`
3. Return: `map.get(head)`

# Complexities
• Time: O(n) - two linear passes
• Space: O(n) - HashMap of size `n`

# What I Learned
- Deep copy requires **translating** pointers through a mapping, not copying references
- `map.get(null) == null` simplifies wiring - no special-case branching needed
- Return the clone of `head`, not `head` itself

# Mistakes to Avoid
- Setting `clone.next = orig.next` or `clone.random = orig.random` (this links to originals)
- Forgetting the `head == null` base case -> should return `null`
- Reusing original nodes or creating clones lazily without ensuring one-to-one mapping

# Alternative (O(1) space idea)
Interweave clones between originals set `random` via `orig.random.next`, then **unweave** to seperate the lists. Same O(n) time, **O(1) extra space**, but trickier to implement
