import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  public int evalRPN(String[] tokens) {
    Deque<Integer> stack = new ArrayDeque<>();

    for (String t : tokens) {
      switch (t) {
        case "+" -> {
          int r = stack.pop();
          int l = stack.pop();
          stack.push(l + r);
        }
        case "-" -> {
          int r = stack.pop();
          int l = stack.pop();
          stack.push(l - r);
        }
        case "*" -> {
          int r = stack.pop();
          int l = stack.pop();
          stack.push(l * r);
        }
        case "/" -> {
          int r = stack.pop();
          int l = stack.pop();
          stack.push(l / r); // java truncates towards zero
        }
        default -> stack.push(Integer.parseInt(t));
      }
    }
    return stack.peek();
  }
}
