package algo;

import java.lang.Iterable;

import java.util.Arrays;

import java.util.Comparator;

import java.util.Iterator;

import java.util.NoSuchElementException;

public class PriorityQueue<T> implements Iterable<T> {
  private Object[] elements = new Object[16];
  private int size;
  private Comparator<T> comparator;

  public PriorityQueue() {
  }

  @SuppressWarnings("unchecked")
  PriorityQueue(Comparator comparator) {
    this.comparator = comparator;
  }

  public void insert(T item) {
    if (!isCapable()) {
      elements = Arrays.copyOf(elements, elements.length * 2);
    }
    elements[++size] = item;

    bubbleUp(size);
  }

  private void bubbleUp(int current) {
    while (current > 1 && greaterThan(current / 2 , current)) {
      swap(current, current / 2);
      current = current / 2;
    }
  }

  @SuppressWarnings("unchecked")
  private boolean greaterThan(int o1, int o2) {
    if (comparator == null) {
      return ((Comparable) elements[o1]).compareTo(elements[o2]) > 0;
    } else {
      return (comparator.compare((T) elements[o1], (T) elements[o2])) > 0;
    }
  }

  @SuppressWarnings("unchecked")
  private void swap(int o1, int o2) {
    T tmp = (T) elements[o1];
    elements[o1] = elements[o2];
    elements[o2] = tmp;
  }

  @SuppressWarnings("unchecked")
  public T min() {
    final T value = (T) elements[1];
    swap(1, size);
    elements[size] = null;
    size--;
    sinkDown(1);

    return value;
  }

  private void sinkDown(int current) {
    while (current * 2 <= size) {
      int childK = current * 2;
      if (childK < size && greaterThan(childK, childK + 1)) {
        childK++;
      }

      if (!greaterThan(current, childK)) {
        break;
      }

      swap(current, childK);
      current = childK;
    }
  }

  private boolean isCapable() {
    return elements.length != size;
  }

  public int size() {
    return size;
  }

  public Iterator<T> iterator() {
    return new Iterator<T>() {

      public boolean hasNext() {
        return (size != 0);
      }

      public T next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        return min();
      }
    };
  }
}
