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
      first = new Node();
      last = new Node();
      first.next = last;
      last.previous = first;
    }
    Node prev = last.previous;
    Node tmp = new Node();
    tmp.item = item;
    tmp.next = last;
    tmp.previous = prev;
    last.previous = tmp;
    prev.next = tmp;
    size++;
  }

  @Override
  public U get(int index) {
    Node current = first.next;
    if (index < 0 || index > size()) {
      System.out.println("Index out of bounds. No node exists at the specified index");
    }
    if (!isEmpty()) {
      for (int i = 0; i < index; i++) {
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
      Node current = first.next;
      for (int i = 0; i < index; i++) {
        current = current.next;
      }
      current.previous.next = current.next;
      current.next.previous = current.previous;
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
    private Node current = first.next;

    public boolean hasNext() {
      return (current.next != null);
    }

    public U next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      U item = current.item;
      current = current.next;
      return item;
    }

  }

  private class ReverseListIterator<T> implements ReverseIterator<U> {
    private Node current = last.previous;

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
