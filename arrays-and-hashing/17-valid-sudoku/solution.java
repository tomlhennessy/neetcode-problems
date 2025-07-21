import java.util.HashSet;
import java.util.Set;

class Solution {
  public boolean isValidSudoku(char[][] board) {

    // Row duplicate check
    for (int r = 0; r < 9; r++) {
      Set<Character> seen = new HashSet<>();
      for (int c = 0; c < 9; c++) {
        char val = board[r][c];

        if (val == '.') {
          continue;
        }

        if (seen.contains(val)) {
          return false;
        }
        seen.add(val);
      }
    }

    // Column check
    for (int c = 0; c < 9; c++) {
      Set<Character> seen = new HashSet<>();
      for (int r = 0; r < 9; r++) {
        char val = board[r][c];

        if (val == '.') {
          continue;
        }

        if (seen.contains(val)) {
          return false;
        }
        seen.add(val);
      }
    }

    // 3x3 sub grid check
    for (int boxRow = 0; boxRow < 9; boxRow += 3) {
      for (int boxCol = 0; boxCol < 9; boxCol += 3) {
        Set<Character> seen = new HashSet<>();
        for (int r = 0; r < 3; r++) {
          for (int c = 0; c < 3; c++) {
            char val = board[boxRow + r][boxCol + c];

            if (val == '.') {
              continue;
            }

            if (seen.contains(val)) {
              return false;
            }

            seen.add(val);

          }
        }
      }
    }

    return true;
  }
}

