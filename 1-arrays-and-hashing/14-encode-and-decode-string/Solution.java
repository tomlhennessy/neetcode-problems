import java.util.ArrayList;
import java.util.List;

public class Solution {
  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String s : strs) {
      sb.append(s.length());
      sb.append('#');
      sb.append(s);
    }
    return sb.toString();
  }

  public List<String> decode(String str) {
    List<String> res = new ArrayList<>();
    int i = 0;
    while (i < str.length()) {
      int j = i;
      while (j < str.length() && str.charAt(j) != '#') {
        j++;
      }
      int len = Integer.parseInt(str.substring(i, j));
      j++;
      res.add(str.substring(j, j + len));
      i = j + len;
    }
    return res;
  }
}
