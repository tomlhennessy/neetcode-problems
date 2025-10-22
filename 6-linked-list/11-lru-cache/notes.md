# Problem Restate
Design an LRU (least recently used) cache that supports
• `get(key)` -> return value or `-1` if not found
• `put(key, value)` -> insert/update value and evict least-recently used if full
Each operation must run in O(1) average time.

# Key Design Question
How can we know both the value (by key) **and** the order of recent usage efficiently?
-> Combine a **HashMap** (for O(1) lookup) with a **doubly linked list** (for O(1) updates to recency order)
• **HashMap**: `key -> node`
• **Doubly Linked List**: tracks recency
  - Head = most recently used (MRU)
  - Tail = least recently used (LRU)

# Why It Works
- Every `get()` or `put()` promotes a key to the MRU position (front)
- The **tail's previous node** always represents the LRU key - evict it when capacity is exceeded
- All list operations (insert/remove/move) are O(1) because of the doubly linked list structure

# Complexities
- Time: O(1) for `get()` and `put()`
- Space: O(capacity)

# What I Learned
- Combine a **hash map** (lookup) and a **doubly linked list** (recency tracking)
- Use **dummy head/tail** to simplify edge cases
- Keep **MRU at head**, **LRU at tail**
- "Moving to front" = remove + insert after head

# Mistakes to Avoid
- Forgetting to **unlink** before re-adding a node
- Using a **singly** linked list (no O(1) removal)
- Returning Node instead of `value` in `get`
- Forgetting to evict from **both list and map** when full
