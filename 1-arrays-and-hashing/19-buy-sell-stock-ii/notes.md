# Problem Restate
Maximise profit with **unlimited** transactions (can buy/sell same day), holding **at most one** share at a time.

# Key Design Question
How to capture all profitable moves without overthinking peaks/valleys?
- **Greedy**: sum every positive day-to-day increase
- Intuition: buying at each valley and selling at each peak == summing all positive deltas between them

# Complexities
Time: O(n)
Space: O(1)

# What I learned
- No single trade; add all rises
- No need to track holding state specifically with this greedy
- Equal prices don't matter

# Mistakes to Avoid
- Solving as Stock I (tracking global min and max profit)
- Using `>=` (doesn't hurt, but unnecessary; zero adds nothing)
- Off-by-one: loop must start at `i = 1`

