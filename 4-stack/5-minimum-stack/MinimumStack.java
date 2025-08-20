import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumStack {
  private Deque<Integer> vals;
  private Deque<Integer> minVal;

  public MinimumStack() {
    vals = new ArrayDeque<>();
    minVal = new ArrayDeque<>();
  }

  public void push(int val) {
    vals.push(val);
    int curMin = minVal.isEmpty() ? val : Math.min(val, minVal.peek());
    minVal.push(curMin);
  }

  public void pop() {
    vals.pop();
    minVal.pop();
  }

  public int top() {
    return vals.peek();
  }

  public int getMin() {
    return minVal.peek();
  }
}
