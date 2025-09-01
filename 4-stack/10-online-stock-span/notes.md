# Problem Restate:
Stream of daily prices. On each `next(price)`, return how many **consecutive** days (including today, going backward) had prices <= today's price.

# Key Design question:
How to avoid re-scanning many past days every call:

Maintain a **monotonic stack** of compressed blocks as (price, span) with prices **strictly decreasing** from top->bottom.
On a new `price`, while `top.price <= price`, pop and **absorb** its `span` into today's span, then push `(price, accumulatedSpan)`

# Complexities:
- **Time**: Amortized O(1) per call, total O(n) over n calls (each item push and popped at most once)
- **Space**: O(n) worst case (strictly decreasing prices keep stacking)

# What I learned:
- Store `(price, span)`, not raw prices or indices -> lets you jump over whole runs of smaller/equal prices in one pop
- Use <= comparison because equal prices count towards the span
- stack invariant: prices decrease down the stack; each element represents a **compressed** block of consecutive days
- keep the stack as a field so history persists across calls

# Mistakes Made:
- Popping the `while` condition instead of using `peek()` first
- Storing only prices (can't accumulate spans) or only indices (extra work to compute spans)
