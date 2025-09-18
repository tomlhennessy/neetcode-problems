# Problem Restate
Group strings so that each sublist contains words that are anagrams of eachother. Order of groups and order within groups doesn't matter.

# Key Design Question
How do I **bucket** anagrams without doing `O(n^2)` pairwise checks
- compute a **canonical key** per word so that all anagrams share the same key
- use a `Map<Key, List<String>>` and append each word to its bucket

# Two Canonical Keys (pick based on constraints)
1) Sorted key (easiest to remember)
- key = sorted characters of the string
```java
char[] chars = s.toCharArray();
Arrays.sort(chars);
String key = new String(chars); // NOT chars.toString()
groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
```

2) Counting key (faster for a-z)
- Key = frequency signature over 26 letters
```java
int[] count = new int[26]
for (int i = 0; i < s.length(); i++) {
  count[s.charAt(i) - 'a']++;
}
StringBuilder sb = new StringBuilder(26 * 2);
for (int c : cnt) {
  sb.append(c).append('#');
}
String key = sb.toString();
groups.computeIfAbsent(key, unused -> new ArrayList<>()).add(s);
```

# Complexities
Let `n` = number of strings, `k` = max string length
Sorted Key: Time O(n·k log k), Space O(n·k)
Counting Key: Time O(n·k), O(n) (26 per key)

# What I learned
- **compute key -> bucket by key -> return values** is the grouping pattern
- `computeIfAbsent` compresses:
  • `if (!map.containsKey(key)) map.put(key, new ArrayList<>());`
  • `map.get(key).add(s)`
- pick the key based on **constraints** (simplicity vs performance)

# Mistakes Made
- using `chars.toString` instead of `new String(chars)` -> wrong key
- forgetting to return `new ArrayList<>(groups.values());`
- overthinking: pairwise `isAnagram` -> `O(n^2)`. Use a **map of buckets** instead

# Interview talk
I group by canonical key. Easiest is sorting each word (O(k log k)). Since inputs are lowercase a-z, I can optimise to a 26-count signature for O(k). I use a hashmap from key to list and return the buckets.

# Core Takeaways
- Pattern: canonical key -> `computeIfAbsent` -> add
- Trade off: sorted key (simple) vs counting key (faster for a-z)
- Avoid O(n^2): never compare pairs, always bucket
