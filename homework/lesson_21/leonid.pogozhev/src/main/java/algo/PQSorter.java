package algo;

public class PQSorter extends PriorityQueue {
  private Order type;

  public PQSorter(Order type) {
    this.type = type;
  }

  public static enum Order {
    ASCENDING, DESCENDING;
  }

  public <T> T[] sort(T[] unsorted) {
    T[] sorted = unsorted;
    
    for (T elem: sorted) {
      insert((Comparable) elem);
    }

    return sorted;
  }
}
