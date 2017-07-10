package algo;

import java.util.NoSuchElementException;

import java.util.Arrays;

import java.util.Comparator;

public class PriorityQueue<T extends Comparable> {
  private Object[] elements = new Object[8];
  private int size;
  private Comparator<T> comparator;

  public PriorityQueue() {};

  public PriorityQueue(Comparator comparator) {
    this.comparator = comparator;
  }

  public void insert(T item) {
    if (!isCapable()) {
      elements = Arrays.copyOf(elements, elements.length * 2);
    }
    elements[++size] = item;

    bubbleUp(size);
  }

  private void bubbleUp(int k) {
    while(k > 1 && greaterOrEqual(k / 2 , k)) {
      swap(k, k / 2);
      k = k / 2;
    }
  }

  private boolean greaterOrEqual(int n, int m) {
    if (comparator == null) {
      return ((Comparable) elements[n]).compareTo(elements[m]) > 0;   
    } else {
      return (comparator.compare((T) elements[n], (T) elements[m])) > 0;
    }
  }

  private void swap(int n, int m) {
    T t = (T) elements[n];
    elements[n] = elements[m];
    elements[m] = t;
  }

  public T min() {
    if (size <= 1) {
      throw new NoSuchElementException();
    }
    if (size == 2) {
      size--;
      return (T) elements[1];
    }

    T value = (T) elements[1];

    swap(1, size);
    elements[size] = null;
    size--;

    sinkDown(1);
    
    return value;
  }

  public void sinkDown(int k){
    T value = (T) elements[k];
    int smallest = k;
    int leftChild = k * 2;
    int rightChild = (k * 2) + 1;

    if(leftChild <= size && greaterOrEqual(k, leftChild)){
      smallest = leftChild;
    }
    if(rightChild <= size && greaterOrEqual(k, rightChild)){
      smallest = k * 2 + 1;
    }
    if(smallest != k){
      swap(k, smallest);
      sinkDown(smallest);
    }
        
  }

  private boolean isCapable() {
    return elements.length != size;
  }
}