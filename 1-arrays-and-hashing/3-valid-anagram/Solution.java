import java.util.HashMap;
import java.util.Map;

public class Solution {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int n = s.length();
    int m = t.length();
    Map<Character, Integer> sCount = new HashMap<>();
    Map<Character, Integer> tCount = new HashMap<>();

    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      sCount.put(ch, sCount.getOrDefault(ch, 0) + 1);
    }

    for (int i = 0; i < m; i++) {
      char ch = t.charAt(i);
      tCount.put(ch, tCount.getOrDefault(ch, 0) + 1);
    }

    return sCount.equals(tCount);
  }
}
