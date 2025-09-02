import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  public String decodeString(String s) {
    Deque<Integer> counts = new ArrayDeque<>();
    Deque<StringBuilder> strings = new ArrayDeque<>();
    StringBuilder cur = new StringBuilder();
    int k = 0;

    for (char ch : s.toCharArray()) {
      if (Character.isDigit(ch)) {
        // accumulate multi digit count into k
        k = k * 10 + (ch - '0');
      } else if (ch == '[') {
        // push context and reset
        counts.push(k);
        strings.push(cur);
        cur = new StringBuilder();
        k = 0;
      } else if (ch == ']') {
        // pop times and previous builder, then set current to previous
        int times = counts.pop();
        StringBuilder prev = strings.pop();
        String segment = cur.toString();
        for (int i = 0; i < times; i++) {
          prev.append(segment);
        }
        cur = prev;
      } else {
        // plain letter
        cur.append(ch);
      }
    }

    return cur.toString();
  }
}
