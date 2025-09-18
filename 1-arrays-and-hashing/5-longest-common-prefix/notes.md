## 1. Always return something at the end
- If no mismatch is found in the first loops, the prefix is the entire first string
- Don't forget a final `return first;`

## 2. Common check pattern
```java
if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
  return first.substring(0, i);
}
```
- Stop immediately if one string is too short
- Stop immediately if a mismatch is found

## 3. Structure to remember
- Guard clause: `if (strs == null || strs.length = 0) return "";`
- Outer loop: iterate over chars of the first string
- Inner loop: compare all other strings at index `i`
- return early on mismatch
- return `first` if loop finishes
