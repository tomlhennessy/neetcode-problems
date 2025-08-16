import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  public int calPoints(String[] operations) {
    Deque<Integer> stack = new ArrayDeque<>();
    int sum = 0;

    for (String op : operations) {
      if (op.equals("+")) {
        // handle sum of last two
        int a = stack.pop();
        int b = stack.peek();
        stack.push(a);
        int sumVal = a + b;
        stack.push(sumVal);
        sum += sumVal;

      } else if (op.equals("D")) {
        // handle double
        int last = stack.peek();
        int doubled = last * 2;
        stack.push(doubled);
        sum += doubled;

      } else if (op.equals("C")) {
        // handle cancel
        int last = stack.pop();
        sum -= last;

      } else {
        int val = Integer.parseInt(op);
        stack.push(val);
        sum += val;

      }
    }

    return sum;
  }
}


