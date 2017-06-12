package algo;

public class BubbleSortBinarySearch extends BinarySearch {

  protected Object[] sort(Object[] unsorted) {
    Object[] sorted = unsorted;
    for (int i = 1; i < sorted.length; i++) {
      for (int j = 0; j < sorted.length - i; j++) {
        Comparable sortVal = (Comparable)sorted[j];
        if (sortVal.compareTo(sorted[j + 1]) > 0) {
          Object temp = sorted[j];
          sorted[j] = sorted[j + 1];
          sorted[j + 1] = temp;
        }
      }
    }
    return sorted;
  }
}
