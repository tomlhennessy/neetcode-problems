

class Solution {
  private static final int ALPHABET = 26;

  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }

    int[] s1Freq = new int[ALPHABET];
    int[] s2Freq = new int[ALPHABET];
    int m = s1.length();
    int n = s2.length();

    for (int i = 0; i < m; i++) {
      s1Freq[s1.charAt(i) - 'a']++;
      s2Freq[s2.charAt(i) - 'a']++;
    }
    if (same(s1Freq, s2Freq)) {
      return true;
    }

    for (int i = m; i < n; i++) {
      s2Freq[s2.charAt(i) - 'a']++;
      s2Freq[s2.charAt(i - m) - 'a']--;
      if (same(s1Freq, s2Freq)) {
        return true;
      }
    }

    return false;
  }

  private boolean same(int[] a, int[] b) {
    for (int i = 0; i < ALPHABET; i++) {
      if (a[i] != b[i]) {
        return false;
      }
    }

    return true;
  }
}
