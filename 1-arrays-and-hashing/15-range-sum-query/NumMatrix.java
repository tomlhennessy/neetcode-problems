class NumMatrix {
  private int[][] pref;

  public NumMatrix(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    pref = new int[m + 1][n + 1];

    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        pref[r + 1][c + 1] = matrix[r][c]       // the cell itself
                            + pref[r][c + 1]    // sum above
                            + pref[r + 1][c]    // sum left
                            - pref[r][c];       // subtract top-left overlap (added twice)
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return pref[row2 + 1][col2 + 1]             // whole area from (0,0) to (row2,col2)
          - pref[row1][col2 + 1]                // cut off rows above row1
          - pref[row2 + 1][col1]                // cut off cols left of col1
          + pref[row1][col1];                   // add back overlap we subtracted twice
  }
}
