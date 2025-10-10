# Problem Restate
Merge two **sorted** linked lists into one sorted list and return the head.
The new list is made up of nodes from `list1` and list2`.

# Core Idea
Use **two pointers** (`list1`, `list2`) and a **dummy + tail** pattern to build the merged list node-by-node.

# Why It Works
- You always attach the **smaller node** to the tail
- Advancing `tail` keeps the list growing in sorted order
- `dummy` avoids needing a "special first node" case - `dummy.next` becomes the real head
- When one list runs out, append the other (it's already sorted)

# Complexities
- Time: O(n + m) - each node visited once
- Space: O(1) - just pointers, no new nodes created

# Steps Summary
1. Base cases: if one list is null -> return the other
2. Initialise `dummy` and `tail = dummy`
3. While both lists exist:
  - Compare `list.val` and `list2.val`
  - Attach smaller node -> `tail.next = smallerNode`
  - Move tail and advance that list's pointer
4. Attach leftover list -> `tail.next = list1 != null ? list1 : list2`
5. Return `dummy.next`

# Common Mistakes
- Using `=` instead of `==` for null checks
- Doing `tail.next = list1.val` (attaching value,  not node)
- Forgetting to advance `tail` or `list1/list2`
- Returning `dummy` instead of `dummy.next`

# What I learned
- A "list" variable is just the **head pointer** to the rest of the chain
- The **dummy-tail** pattern simplifies linked list construction
- You can always append the remainder list directly because its already sorted.
