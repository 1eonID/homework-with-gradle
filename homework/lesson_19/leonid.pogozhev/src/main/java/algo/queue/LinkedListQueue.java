package algo.queue;

import java.util.NoSuchElementException;

public class LinkedListQueue<T> implements Queue<T> {
  private int size;
  private Node first;
  private Node last;

  private class Node {
    private T item;
    private  Node next;
  }

  public void enqueue(T item) {
    Node tmp = new Node();
    tmp.item = item;
    if (isEmpty()) {
      first = tmp;
    } else {
      last.next = tmp;
    }
    last = tmp;
    size++;
  }

  public T dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("Nothing to dequeue, queue is empty.");
    } else if (first.next == null) {
      last = null;
    }
    T tmp = first.item;
    first = first.next;
    size--;
    return tmp;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public int size() {
    return size;
  }

  public void clear() {
    first = null;
    size = 0;
  }

  public Iterator<T> iterator() {
    return new QueueIterator<>();
  }

  //In this iterator our queue outputing in order: "Firts In First Out".
  private class QueueIterator<U> implements Iterator<T> {
    private Node current = first;

    public boolean hasNext() {
      return (current != null);
    }

    public T next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      T item = current.item;
      current = current.next;
      return item;
    }
  }
}
