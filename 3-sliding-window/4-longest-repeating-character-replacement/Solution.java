

public class Solution {
  public int characterReplacement(String s, int k) {
    int[] freq = new int[26];
    int j = 0;
    int maxLength = 0;
    int maxFreq = 0;

    for (int i = 0; i < s.length(); i++) {
      // update freq and maxFreq
      char c = s.charAt(i);
      freq[c - 'A']++;
      maxFreq = Math.max(maxFreq, freq[c - 'A']);

      // remove leftmost char (if necessary)
      if ((i - j + 1) - maxFreq > k) {
        freq[s.charAt(j) - 'A']--;
        j++;
      }

      // update longest
      maxLength = Math.max(maxLength, i - j + 1);
    }
  }
}
