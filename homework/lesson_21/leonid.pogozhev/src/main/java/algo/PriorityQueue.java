package algo;

import java.util.Arrays;

import java.util.Comparator;

import static algo.PQSorter.Order.*;

public class PriorityQueue<T extends Comparable> {
  private Object[] elements = new Object[16];
  private int size;
  Comparator<T> comparator;

  public PriorityQueue() {
    
  };

  @SuppressWarnings("unchecked")
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
    while(k > 1 && compare(k / 2 , k)) {
      swap(k, k / 2);
      k = k / 2;
    }
  }

  @SuppressWarnings("unchecked")
  private boolean compare(int n, int m) {
    if (comparator == (T) ASCENDING) {
      return (comparator.compare((T) elements[n], (T) elements[m])) > 0;
    } else if (comparator == (T) DESCENDING) {
      return (comparator.compare((T) elements[n], (T) elements[m])) < 1;
    }
    return ((Comparable) elements[n]).compareTo(elements[m]) > 0;
  }

  @SuppressWarnings("unchecked")
  private void swap(int n, int m) {
    T t = (T) elements[n];
    elements[n] = elements[m];
    elements[m] = t;
  }

  @SuppressWarnings("unchecked")
  public T min() {
    T value = (T) elements[1];

    swap(1, size);
    elements[size] = null;
    size--;

    sinkDown(1);

    return value;
  }

  @SuppressWarnings("unchecked")
  public void sinkDown(int k){
    T value = (T) elements[k];
    int smallest = k;
    int leftChild = k * 2;
    int rightChild = (k * 2) + 1;

    if(leftChild <= size && compare(k, leftChild)){
      smallest = leftChild;
    }
    if(rightChild <= size && compare(k, rightChild)){
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
