# Problem Restate
Implement a set of ints with `add`, `remove`, `contains` - **no built-in hash tables**

# Key Design Choice
Given `0 <= key <= 1_000_000`, the key space is small and fixed -> use **direct addressing**:
- Index = key (or `key - L` if range is `[L...R]`)
- No hashing, no collisions, true O(1) ops

# Minimal Templates
boolean[] version (simple):
```java
class MyHashSet {
  private final boolean[] seen = new boolean[1_000_001];

  public void add(int key) { seen[key] = true; }
  public void remove(int key) { seen[key] = false; }
  public boolean contains(int key) { return seen[key]; }
}
```

BitSet version (8x less memory):
```java
import java.util.BitSet;

class MyHashSet {
  private final BitSet bits = new BitSet(1_000_001);

  public void add(int key) { bits.set(key); }
  public void remove(int key) { bits.clear(key); }
  public boolean contains(int key) { return bits.get(key); }
}
```

# What I learned
- When the domain is small and bounded, the **key is the index**
- Direct addressing beats hashing: simpler, faster, zero collisions
- Use BitSet when memory matters; same idea

# Mistakes to avoid
- Over-engineering with buckets/probing when the domain is tiny
- Forgetting offset when the keys don't start at 0 (`index = key - L`)
- Returning/iterating structures that rely on order (a set doesn't)

# When not to use direct addressing
- Huge/sparse or unknown key space
- negative/non-integer keys
-> use a real hash table (buckets or open addressing)

