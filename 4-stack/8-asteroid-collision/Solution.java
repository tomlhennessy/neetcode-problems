import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  public int[] asteroidCollision(int[] asteroids) {
    Deque<Integer> st = new ArrayDeque<>();

    for (int a : asteroids) {
      boolean alive = true;
      while (alive && !st.isEmpty() && st.peek() > 0 && a < 0) {
        int top = st.peek();
        if (top < -a) {
          // top explodes
          st.pop();
        } else if (top == -a) {
          // both explode
          st.pop();
          alive = false;
        } else {
          // a explodes
          alive = false;
        }
      }
      if (alive) st.push(a);
    }
    int[] res = new int[st.size()];
    for (int i = st.size() - 1; i >= 0 ; i--) {
      res[i] = st.pop();
    }
    return res;
  }
}
