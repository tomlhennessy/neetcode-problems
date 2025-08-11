# Problem Restate:
Find the longest substring of duplicate characters, with `k` number of letter replacements allowed.

# Key Design question:
(Sliding window + char frequency)
Slide a window across `s` and:
- Track char counts using `freq[26]` array
- Keep `maxFreq` (the highest frequency in the current window)
- If `window size - maxFreq > k`, shrink from the left
- Track the max window length seen

# Complexities:
time complexity: O(n)
space complexity: O(1)

# What I learned:
Java chars are backed by ASCII values. 'A' has ASCII code **65**
s.charAt(i) - 'A' means: ASCII of current char - ASCII of 'A'
This gives a **0-based** index from 0 to 25

So `freq[s.charAt(i) - 'A']++` says:
"Increment the frequency of the current char in the window"

We don't have to recompute `maxFreq` because:
- We're only ever trying to **expand the longest possible window**
- Letting it be "too high" just makes us shrink it a bit earlier - no harm done.

# Mistakes Made:
- decrement must come before incrementing `l`
- No need to cast as (int); c - 'A' gets the index
- accidentally assigning the character index instead of its frequency
- mixing up pointers and wrong calculation for size of window
