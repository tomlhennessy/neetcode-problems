# HashMap Notes

## 1. Basic Rule:
- You can't use map[i] = value in Java.
- Always use `.put(key, value)`

## 2. Counting Pattern
```java
char ch = s.charAt(i);
map.put(ch, map.getOrDefault(ch, 0) + 1);
```
- `getOrDefault(ch, 0)` -> fetch current count or `0` if absent
- then add `1`

## 3. Comparing Maps
- Use `map1.equals(map2)` -> compares both keys and values

## 4. Common mistake I made
- Tried to assign map[i] = value
- forgot to use `getOrDefault` when counting

## 5. Takeaway
- Think of HashMap as: "look up with `get`, update with `put`"
- For counting, always remember the counting pattern
