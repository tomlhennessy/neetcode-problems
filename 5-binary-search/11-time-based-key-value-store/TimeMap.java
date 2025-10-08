import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
  private static final class Entry {
    final int ts;
    final String val;

    Entry(int ts, String val) {
      this.ts = ts;
      this.val = val;
    }
  }

  private final Map<String, List<Entry>> map;

  public TimeMap() {
    this.map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    List<Entry> list = map.get(key);
    if (list == null) {
      list = new ArrayList<>();
      map.put(key, list);
    }
    list.add(new Entry(timestamp, value));
  }

  public String get(String key, int timestamp) {
    List<Entry> list = map.get(key);
    if (list == null || list.isEmpty()) {
      return "";
    }

    int lo = 0;
    int hi = list.size() - 1;
    int ans = -1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;

      if (list.get(mid).ts <= timestamp) {
        ans = mid;
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }

    return ans == -1 ? "" : list.get(ans).val;
  }
}
