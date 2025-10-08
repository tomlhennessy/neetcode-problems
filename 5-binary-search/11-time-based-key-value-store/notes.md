# Problem Restate
Store multiple `(value, timestamp)` per `key`.
`set(key, value, ts)` appends
`get(key, t)` returns the most recent value with `ts <= t`, or `""` if none.
Timestamps for a given key are **strictly increasing**.

# Key Design Question
How do we quickly find the **rightmost** `ts <= t` per key?

# Why It Works
Per key, keep values in **time order**.
- `set`: append -> O(1) amortised
- `get`: **binary search for floor** (` rightmost ts <= t `) -> O(log m)

# Data Model (simple + fast)
- `Map<String, List<Entry>> map`
- `Entry { int ts; String val; }`
Each key maps to a sorted list of `(ts, val)`

# Algorithm Core (closed interval floor search)
1. `set`:
  - `list = map.get(key)` or make one
  - `list.add(new Entry(ts, value))`
2. `get`:
  - `list = map.get(key)`; if null/empty -> `""`
  - Optional fast path: if `last.ts <= t` -> return `last.val`
  - **Binary search (floor)**
  ```java
  lo = 0, hi = list.size() - 1, ans = -1;
  while (lo <= hi):
    mid = lo + (hi - lo) / 2
    if (list[mid].ts <= t): ans = mid; lo = mid + 1   // go right
    else: hi = mid - 1
  return ans == -1 ? "" : list[ans].val
  ```

# Bound Rules (cheat sheet)
- Floor search: we want the **rightmost** index where `ts <= t`
- If condition succeeds (`<= t`): **record it** and **move right**
- If `ts > t` move **left**

# Complexities
- **set**: O(1) amortised per call
- **get**: O(log m) per key (m = entries for that key)
- **space**: O(total set calls)

# What I Learned
- Model per-key data as an **append-only sorted list**
- Floor binary search pattern = "**on success, go right**"
- Early exit on `last.ts <= t` shaves comparisons

# Mistakes to Avoid
- Using `< t` instead of `<= t` (you'd skip exact matches)
- Moving left on success (thats ceil, not floor)
- Forgetting empty / missing key -> must return `""`
- Resorting per set - unecessary; timestamps are already increasing
