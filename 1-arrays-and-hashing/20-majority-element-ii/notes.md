# Problem Restate
Return all elements appearing more than **[n/3] times** (0-2 answers)

# Key Design Question
How to get it in O(n) time, O(1) space?
- Use Boyer-Moore (n/3) variant:
  • Keep two candidates and counts
  • Single pass to select candidates by cancelling triples
  • Second pass to verify counts

# Why it Works
Every time you see three different numbers, they can't all be > n/3; cancelling keeps potential majorities alive while non-majorities vanish.

# Complexities
Time: O(n) (two passes)
Space: O(1)

# What I Learned
- For threshold > n/k, you need k-1 candidates
- Verification pass is mandatory; selection doesn't guarantee frequency
- Guard against `cand1 == cand2` when adding results

# Mistakes to Avoid
- Returning candidates without verification
- Forgetting to reset counts before verification
- Using same initial value for both candidates (make them distinct or rely on counts)
