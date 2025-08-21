import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> res= new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    dfs(n, 0, 0, sb, res);
    return res;

  }

  private void dfs(int n, int open, int close, StringBuilder sb, List<String> res) {
    // base case + choices will go here
    if (sb.length() == 2 * n) {
      res.add(sb.toString());
      return;
    }

    if (open < n) {
      sb.append('(');
      dfs(n, open + 1, close, sb, res);
      sb.deleteCharAt(sb.length() - 1);
    }
    if (close < open) {
      sb.append(')');
      dfs(n, open, close + 1, sb, res);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
