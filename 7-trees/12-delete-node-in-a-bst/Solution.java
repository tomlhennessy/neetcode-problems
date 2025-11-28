

public class Solution {
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }

    if (key < root.val) {
      root.left = deleteNode(root.left, key);
    } else if (key > root.val) {
      root.right = deleteNode(root.right, key);
    } else {
      // key == root.val -> delete this node

      // case 1: no children
      if (root.left == null && root.right == null) {
        return null;
      }

      // case 2: one child
      if (root.left == null) {
        return root.right;
      }
      if (root.right == null) {
        return root.left;
      }

      // case 3: two children
      TreeNode curr = root.right;
      while (curr.left != null) {
        curr = curr.left;
      }

      // copy value
      root.val = curr.val;

      // delete that node from the right subtree
      root.right = deleteNode(root.right, curr.val);
    }

    return root;
  }
}
