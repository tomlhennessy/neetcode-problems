
public class Solution {
  public String mergeAlternatively(String word1, String word2) {
    int i = 0, j = 0;
    StringBuilder res = new StringBuilder();

    while (i < word1.length() || j < word2.length()) {
      if (i < word1.length()) {
        res.append(word1.charAt(i++));
      }
      if (j < word2.length()) {
        res.append(word2.charAt(j++));
      }

    }

    return res.toString();
  }
}
