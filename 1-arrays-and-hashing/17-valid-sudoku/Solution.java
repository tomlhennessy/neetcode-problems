import java.util.HashSet;
import java.util.Set;

class Solution {
  public boolean isValidSudoku(char[][] board) {
    @SuppressWarnings("unchecked")
    Set<Character>[] rows = new HashSet[9];
    @SuppressWarnings("unchecked")
    Set<Character>[] cols = new HashSet[9];
    @SuppressWarnings("unchecked")
    Set<Character>[] boxes = new HashSet[9];

    for (int i = 0; i < 9; i++) {
      rows[i] = new HashSet<>();
      cols[i] = new HashSet<>();
      boxes[i] = new HashSet<>();
    }

    for (int r = 0; r < 9; r++) {
      for (int c = 0; c < 9; c++) {
        char ch = board[r][c];
        if (ch == '.') {
          continue;
        }
        int b = (r / 3) * 3 + (c / 3);    // box index
        if (!rows[r].add(ch) || !cols[c].add(ch) || !boxes[b].add(ch)) {
          return false;
        }
      }
    }
    return true;
  }
}
