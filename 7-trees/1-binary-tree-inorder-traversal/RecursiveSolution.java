
public class RecursiveSolution {
  void inorder(TreeNode node, List<Integer> res) {
    if (node == null) { return; }

    // 1. visit left subtree
    inorder(node.left, res);

    // 2. add current node
    res.add(node.val);

    // 3. visit right subtree
    inorder(node.right, res);
  }
}
