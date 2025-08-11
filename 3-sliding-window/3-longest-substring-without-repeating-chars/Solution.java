import java.util.HashSet;
import java.util.Set;

public class Solution {
  public int lengthOfLongestSubstring(String s) {
    Set<Character> sub = new HashSet<>();
    int longest = 0;
    int j = 0; // leftmost char in substring

    for (int i = 0; i < s.length(); i++) {
      while (sub.contains(s.charAt(i))) {
        sub.remove(s.charAt(j++));
      }

      sub.add(s.charAt(i));

      longest = Math.max(longest, sub.size());
    }

    return longest;
  }
}
