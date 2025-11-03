import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class IterativeSolution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();

    TreeNode curr = root;

    while (curr != null || !stack.isEmpty()) {
      // Phase 1: dive left
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }

      // Phase 2: visit + go right
      TreeNode node = stack.pop();
      res.add(node.val);
      curr = node.right;
    }

    return res;
  }
}
