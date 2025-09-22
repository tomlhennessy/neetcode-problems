

public class Solution {
  public int[] sortArray(int[] nums) {
    int n = nums.length;
    int[] temp = new int[n];
    mergeSort(nums, 0, n - 1, temp);
    return nums;
  }

  private void mergeSort(int[] a, int l, int r, int[] temp) {
    if (l >= r) {
      return;
    }

    int m = l + (r - l) / 2;
    mergeSort(a, l, m, temp);
    mergeSort(a, m + 1, r, temp);

    // micro-opt: halves already in global order? skip merge
    if (a[m] <= a[m + 1]) { return; }

    merge(a, l, m, r, temp);
  }

  private void merge(int[] a, int l, int m, int r, int[] temp) {
    for (int t = l; t <= r; t++) {
      temp[t] = a[t];
    }

    int i = l;        // left half in temp
    int j = m + 1;    // right half in temp
    int k = l;        // write index in a;

    while (i <= m && j <= r) {
      if (temp[i] <= temp[j]) {
        a[k++] = temp[i++];
      } else {
        a[k++] = temp[j++];
      }
    }

    while (i <= m) {
      a[k++] = temp[i++];
    }
  }
}
