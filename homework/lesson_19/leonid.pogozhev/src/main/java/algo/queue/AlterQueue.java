package algo.queue;

import java.util.NoSuchElementException;

public class AlterQueue<T> implements Queue<T> {
  private Object[] elements = new Object[10];
  private int putIndex;
  private int firstElemIndex;
  private int size;

  public void enqueue(T item) {
    if (!isCapable()) {
      increaseCapacity();
    }
    elements[putIndex++] = item;

    size++;
  }

  private boolean isCapable() {
    return putIndex < elements.length;
  }

  private void increaseCapacity() {
    Object[] newElements = new Object[elements.length * 2];
    System.arraycopy(elements, 0, newElements, 0, elements.length);
    elements = newElements;
  }

  @SuppressWarnings("unchecked")
  public T dequeue() {
    size--;
    T value = (T) elements[firstElemIndex];
    elements[firstElemIndex++] = null;

    return value;
  }

  public int size() {
    return size;
  }

  public void clear() {
    size = 0;
    elements = new Object[10];
  }

  public Iterator<T> iterator() {
    return new AlterQueueIterator<>();
  }

  //Iterator for our queue, from first element in queue to last.
  @SuppressWarnings("unchecked")
  private class AlterQueueIterator<U> implements Iterator<T> {
    private int curIndex = firstElemIndex;

    public boolean hasNext() {
      return (curIndex < putIndex);
    }

    public T next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      return (T) elements[curIndex++];
    }
  }
}
