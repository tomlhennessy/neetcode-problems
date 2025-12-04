

public class Solution {
  public Node construct(int[][] grid) {
    int n = grid.length;
    if (n == 0) {
      return null;
    }
    // call the helper on the whole grid
    return build(grid, 0, 0, n);
  }

  private Node build(int[][] grid, int row, int col, int size) {
    if (isUniform(grid, row, col, size)) {
      // create and return a leaf node
      // val should be true if this region is 1, false if 0
      boolean val = grid[row][col] == 1;
      return new Node(val, true);
    }

    int half = size / 2;
    Node topLeft = build(grid, row, col, half);
    Node topRight = build(grid, row, col + half, half);
    Node bottomLeft = build(grid, row + half, col, half);
    Node bottomRight = build(grid, row + half, col + half, half);

    return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
  }

  // returns true if all values in the sub-square are the same
  private boolean isUniform(int[][] grid, int row, int col, int size) {
    int first = grid[row][col];

    for (int r = row; r < row + size; r++) {
      for (int c = col; c < col + size; c++) {
        if (grid[r][c] != first) {
          return false;
        }
      }
    }

    return true;
  }
}
