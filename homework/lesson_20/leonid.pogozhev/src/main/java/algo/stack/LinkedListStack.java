package algo.stack;

import java.util.NoSuchElementException;

public class LinkedListStack<T> implements Stack<T> {
  private int size;
  private Node first;

  private class Node {
    private T item;
    private  Node next;
  }

  public void push(T item) {
    if (isEmpty()) {
      first = new Node();
      first.item = item;
    } else {
      Node tmp = first;
      first = new Node();
      first.item = item;
      first.next = tmp;
    }
    size++;
  }

  public T pop() {
    if (isEmpty()) {
      throw new NoSuchElementException("Nothing to dequeue, queue is empty.");
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
    return new LinkedListStackIterator<>();
  }

  //Stack iterator in LIFO order
  private class LinkedListStackIterator<U> implements Iterator<T> {
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
