import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack {
  private Queue<Integer> q1 = new ArrayDeque<>();
  private Queue<Integer> q2 = new ArrayDeque<>();


  public MyStack() {

  }

  public void push(int x) {
    q2.offer(x); // add new element to q2

    while (!q1.isEmpty()) {
      q2.offer(q1.poll());
    }

    // swap queues
    Queue<Integer> temp = q1;
    q1 = q2;
    q2 = temp;
  }

  public int pop() {
    return q1.poll();
  }

  public int top() {
    return q1.peek();
  }

  public boolean empty() {
    return q1.isEmpty();
  }
}
