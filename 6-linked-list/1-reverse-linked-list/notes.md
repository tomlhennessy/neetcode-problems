# Problem Restate
Given the head of a **singly** linked list, reverse it and return the **new head**.

# Key Design Questions
- Iterative: What invariant do I maintain while walking? Which pointer must I save before flipping?
- Recursive: What are the **base cases**? After reversing the tail, how do I **rewire** two pointers without creating a cycle?

# Why It Works
- Reversal = flip each `next` pointer to point backward
- Iterative: build a reversed prefix; move forward one node at a time
- Recursive: reverse the rest first; on unwind, point child back to parent, then detach parent's old next

# Complexities
Time: O(n) both
Space: iterative O(1); recursive O(n) call stack

# What I learned
- Always save `next` before flipping or you lose the list
- Iterative invariant: `prev` = reversed prefix head
- Recursive mental model: reverse the rest -> hook the current node after it -> detach
- The critical recursive pair: `head.next.next = head;` then `head.next = null;`

# Mistakes to avoid
- Declaring curr/prev/next as int instead of `ListNode`
- Forgetting `next = curr.next` save
- Returning head after iterative loop; should return `prev`
- Recursive: using a non-existent prev field
- Recursive: not setting `head.next = null` -> creates a **cycle**
- Overthinking base cases: `head == null || head.next == null` is enough
