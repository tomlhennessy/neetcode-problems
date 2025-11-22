import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) { return res; }
    Deque<TreeNode> stack = new ArrayDeque<>();

    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();

      // 1) visit node (add to res immediately)
      res.add(node.val);

      // 2) push children in reversed-preorder order
      // push right first, then left
      if (node.left != null) { stack.push(node.left); }
      if (node.right != null) { stack.push(node.right); }
    }

    // 3) reverse result to convert Node->Right->Left into Left->Right->Node
    Collections.reverse(res);
    return res;
  }
}
