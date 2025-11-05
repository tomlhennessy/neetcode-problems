import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();

    TreeNode curr = root;

    while (curr != null || !stack.isEmpty()) {
      // walk down left spine
      while (curr != null) {
        res.add(curr.val);
        stack.push(curr);
        curr = curr.left;
      }

      // finished a left chain: pop and go right
      TreeNode node = stack.pop();
      curr = node.right;
    }

    return res;
  }
}
