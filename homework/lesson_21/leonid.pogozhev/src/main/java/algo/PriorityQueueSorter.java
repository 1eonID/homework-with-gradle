package algo;

import java.util.Comparator;

public class PriorityQueueSorter {
  private Order type;

  public PriorityQueueSorter(Order type) {
    this.type = type;
  }

  public static enum Order {
    ASCENDING, DESCENDING
  }

  @SuppressWarnings("unchecked")
  public <T> T[] sort(T[] unsorted) {
    PriorityQueue<T> pq = new PriorityQueue<>(new Comparator() {
      @Override
      public int compare(Object o1, Object o2) {
        if (type == Order.DESCENDING) {
          return -1 * ((Comparable) o1).compareTo(o2);
        }
        return ((Comparable) o1).compareTo(o2);
      }
    });

    for (T elem: unsorted) {
      pq.insert(elem);
    }
    T[] sorted = (T[]) new Object[unsorted.length];

    for (int i = 0; i < unsorted.length; i++) {
      sorted[i] = pq.min();
    }

    return sorted;
  }
}
