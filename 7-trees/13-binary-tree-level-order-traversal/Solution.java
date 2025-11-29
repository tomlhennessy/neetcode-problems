import java.util.ArrayDeque;
import java.util.List;

public class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
      return new ArrayList<>();
    }

    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.addLast(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> level = new ArrayList<>();

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.removeFirst();

        level.add(node.val);

        if (node.left != null) {
          queue.addLast(node.left);
        }

        if (node.right != null) {
          queue.addLast(node.right);
        }
      }
      result.add(level);
    }

    return result;
  }
}
