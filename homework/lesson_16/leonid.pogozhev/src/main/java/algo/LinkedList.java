package algo;

import java.util.NoSuchElementException;

public class LinkedList<U> implements List<U> {
  private int size;
  private Node first;
  private Node last;

  private class Node {
    private U item;
    private  Node next;
    private Node previous;
  }

  @Override
  public void add(U item) {
    if (isEmpty()) {
      Node tmp = new Node();
      tmp.item = item;
      first = tmp;
      last = tmp;
    }
    // Node prev = last.previous;
    // tmp.next = last;
    // tmp.previous = prev;
    // last.previous = tmp;
    // prev.next = tmp;
    Node tmp = last;
    last = new Node();
    last.item = item;
    last.previous = tmp;
    tmp.next = last;
    size++;
  }

  @Override
  public U get(int index) {
    Node current = first;
    if (index < 0 || index > size()) {
      System.out.println("Index out of bounds. No node exists at the specified index");
    }
    if (!isEmpty()) {
      for (int i = 0; i < index + 1; i++) {
        current = current.next;
      }
    } else {
      System.out.println("Empty list");
    }
    return current.item;
  }

  @Override
  public void remove(int index) {
    if (index < 0 || index > size()) {
      System.out.println("Index out of bounds. No node exists at the specified index");
    }
    if (!isEmpty()) {
      Node current = first;
      if (index == 0) {
        first = first.next;
      } else if (index == size - 1) {
        last = last.previous;
      } else {
        for (int i = 0; i < index + 1; i++) {
          current = current.next;
        }
        current.previous.next = current.next;
        current.next.previous = current.previous;
      }
      size--;
    } else {
      System.out.println("Empty list");
    }
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void clear() {
    size = 0;
  }

  @Override
  public Iterator<U> iterator() {
    return new ListIterator<>();
  }

  @Override
  public ReverseIterator<U> reverseIterator() {
    return new ReverseListIterator<>();
  }

  private class ListIterator<T> implements Iterator<U> {
    private Node current = first;

    public boolean hasNext() {
      return (current.next != null);
    }

    public U next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      current = current.next;
      U item = current.item;
      return item;
    }

  }

  private class ReverseListIterator<T> implements ReverseIterator<U> {
    private Node current = last;

    public boolean hasPrevious() {
      return (current.previous != null);
    }

    public U previous() {
      if (!hasPrevious()) {
        throw new NoSuchElementException();
      }
      current = current.previous;
      return current.next.item;
    }
  }
}
