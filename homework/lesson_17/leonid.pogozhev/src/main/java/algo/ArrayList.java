package algo;

import static java.util.Collections.shuffle;

import java.util.Arrays;

import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T> {
  private int size = 0;
  private static final int DEFAULT_CAPACITY = 10;
  private Object[] elements;

  public ArrayList() {
    elements = new Object[DEFAULT_CAPACITY];
  }

  public void add(T item) {
    if (size == elements.length) {
      ensureCapa();
    }
    elements[size++] = item;
  }

  private void ensureCapa() {
    int newSize = elements.length * 2;
    elements = Arrays.copyOf(elements, newSize);
  }

  @SuppressWarnings("unchecked")
  public T get(int index) {
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    return (T) elements[index];
  }

  public void remove(int index) {
    if (index < size && index > -1) {
      int temp = index;
      while (temp < size) {
        elements[temp] = elements[temp + 1];
        temp++;
      }
      size--;
    } else {
      throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
  }

  public boolean isEmpty() {
    return (size() == 0);
  }

  public int size() {
    return size;
  }

  public void clear() {
    size = 0;
    elements = new Object[DEFAULT_CAPACITY];
  }

  @SuppressWarnings("unchecked")
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      int currentIndex;

      public boolean hasNext() {
        return (currentIndex != size);
      }

      public T next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        return (T) elements[currentIndex++];
      }
    };
  }

  @SuppressWarnings("unchecked")
  public ReverseIterator<T> reverseIterator() {
    return new ReverseIterator<T>() {
      int currentIndex = size - 1;

      public boolean hasPrevious() {
        return (currentIndex > -1);
      }

      public T previous() {
        if (!hasPrevious()) {
          throw new NoSuchElementException();
        }
        return (T) elements[currentIndex--];
      }
    };
  }

  @SuppressWarnings("unchecked")
  public Iterator<T> randomIterator() {
    return new Iterator<T>() {
      Object[] tmp = Arrays.copyOf(elements, size);

      {
        shuffle(Arrays.asList(tmp));
      }

      int currentIndex;

      public boolean hasNext() {
        return (currentIndex != size);
      }

      public T next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        return (T) tmp[currentIndex++];
      }
    };
  }
}
