# HashMap Notes

## 1. Lookup Pattern:
```java
if (map.containsKey(key)) {
  map.get(key);
}
```
- Use `containsKey()` instead of `map[key] != null`

## 2. Algorithm Idea
- For each number `x`, compute `target - x`
- If it's in the map -> solution found
- Else store `x` in the map with its index

## 3. Map Usage
- Key = number
- Value = index


