# Problem restate
Implement `put`, `get`, `remove` for int keys/values (`0...1_000_000`) without built-in hash tables.
Return `-1` on `get` if key not present.

# Key Design Choice
Constraints -> **direct addressing** (skip hashing):
- Universe is small and fixed -> index is the key
- Use an `int[]` to store values and a sentinel for "missing"

# Minimal Template
```java
import java.util.Arrays;

class MyHashMap {
  private static final int MAX = 1_000_000;
  private final int[] vals;

  public MyHashMap() {
    vals = new int[MAX + 1];
    Arrays.fill(vals, -1);
  }

  public put(int key, int value) {
    vals[key] = value;
  }

  public remove(int key) {
    vals[key] = -1;
  }

  public get(int key) {
    return vals[key];
  }
}
```

# Why this works
- Sentinel is valid: values are non-negative, so `-1` can safely mean "absent"
- O(1) worst case for all ops: no collisions, no probing

# What I learned
- Read constraints first: if the key domain is bounded and small, prefer **direct addressing**
- For sets: `boolean[]`/`BitSet`
- For maps: `int[]` + **sentinel** (or `BitSet present + int[]` if values could be negative).
- Keep API semantics straight: `put` overwrites, `get` returns -1 if absent, `remove` is a no-op if absent

