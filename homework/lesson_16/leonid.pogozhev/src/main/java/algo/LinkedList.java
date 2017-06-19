package algo;

import java.util.NoSuchElementException;

public class LinkedList<U> implements List<U> {
  private int size;
  private Node first;
  private Node last;

  public LinkedList() {
    first = new Node();
    last = new Node();
    first.next = last;
    last.previous = first;
  }

  private class Node {
    private U item; //U
    private  Node next;
    private Node previous; //prev
  }

  @Override
  public void add(U item) {
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
    return null;
  }

  @Override
  public void remove(int index) {

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
    return new ListIterator();
  }

  @Override
  public ReverseIterator<U> reverseIterator() {
    return new ReverseListIterator();
  }

  // your code here

  private class ListIterator<U> implements Iterator<U> {
    private Node current = first.next;
    private Node lastAccessed = null;

    private int index = 0;

    public boolean hasNext() {
      return (index < size);
    }

    public U next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      lastAccessed = current;
      U item = (U) current.item;
      current = current.next;
      index++;
      return item;
    }

  }

  private class ReverseListIterator<U> implements ReverseIterator<U> {
    private Node current = first.next;
    private Node lastAccessed = null;

    private int index = 0;

    public boolean hasPrevious() {
      return (index > 0);
    }

    public U previous() {
      if (!hasPrevious()) {
        throw new NoSuchElementException();
      }
      current = current.previous;
      index--;
      lastAccessed = current;
      return (U) current.item;
    }
  }
}
