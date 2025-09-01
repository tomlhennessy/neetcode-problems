import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  public String simplifyPath(String path) {
    Deque<String> st = new ArrayDeque<>();
    for (String part : path.split("/")) {
      if (part.isEmpty() || part.equals(".")) {
        continue;                                 // ignore no-ops
      } else if (part.equals("..")) {
        if (!st.isEmpty()) { st.removeLast(); }   // go up one directory
      } else {
        st.addLast(part);                         // real directory name
      }
    }

    return st.isEmpty() ? "/" : "/" + String.join("/", st);
  }
}
