import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {
  private Deque<Integer> in = new ArrayDeque<>();
  private Deque<Integer> out = new ArrayDeque<>();

  public MyQueue() {

  }

  public void push(int x) {
    in.push(x);
  }

  public int pop() {
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        out.push(in.pop());
      }
    }

    return out.pop();

  }

  public int peek() {
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        out.push(in.pop());
      }
    }

    return out.peek();
  }

  public boolean empty() {
    return (in.isEmpty() && out.isEmpty());
  }
}
