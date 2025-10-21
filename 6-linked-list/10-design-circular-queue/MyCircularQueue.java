

public class MyCircularQueue {
  private int[] data;
  private int head;
  private int size;
  private int cap;

  public MyCircularQueue(int k) {
    this.cap = k;
    this.data = new int[k];
    this.head = 0;
    this.size = 0;
  }

  public boolean enQueue(int value) {
    if (isFull()) { return false; }

    int tail = (head + size) % cap;
    data[tail] = value;
    size++;
    return true;
  }

  public boolean deQueue() {
    if (isEmpty()) { return false; }
    head = (head + 1) % cap;
    size--;
    return true;
  }

  public int front() {
    if (isEmpty()) { return -1; }

    return data[head];
  }

  public int rear() {
    if (isEmpty()) { return -1; }

    return data[(head + size - 1) % cap];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == cap;
  }
}
