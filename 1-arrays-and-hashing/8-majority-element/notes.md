# Problem Restate
Find the element that appears > n/2 times. It's guaranteed to exist.

# Core Pattern (Boyer-Moore voting)
- Maintain `candidate` and `count`
- Scan once:
  • if `count == 0`: set `candidate = x`, `count = 1`
  • else if `x = candidate`: `count++`
  • else: `count--`
- Return `candidate`

# Template
```java
int candidate = nums[0];
int count = 1;

for (int i = 1; i < nums.length; i++) {
  int x = nums[i];
  if (x == candidate) {
    count++;
  } else if (count == 0) {
    candidate = x;
    count = 1;
  } else {
    count--;
  }
}
return candidate;
```

# Why it Works
Pair-cancellation: Every non-candidate cancels one occurance; a true majority survives all cancellations

# Complexity
Time: O(n) single pass
Space: O(1)


