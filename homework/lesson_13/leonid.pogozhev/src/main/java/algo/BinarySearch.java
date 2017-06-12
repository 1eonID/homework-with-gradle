package algo;

public abstract class BinarySearch {
  public final int perform(Object[] unsorted, Object toFind) {
    // your code here
    int index = -1;
    Object[] sorted = sort(unsorted);
    index = binarySearch(sorted, toFind);
    return index;
  }

  protected abstract Object[] sort(Object[] unsorted);

  private int binarySearch(Object[] sorted, Object toFind) {
    return binarySearchAux(sorted, 0, sorted.length, toFind);
  }

  private int binarySearchAux(Object[] sorted, int fromIndex, int toIndex, Object key) {

    int low = fromIndex;
    int high = toIndex - 1;

    while (low <= high) {
      int mid = (low + high) >>> 1;

      Comparable midVal = (Comparable)sorted[mid];

      int cmp = midVal.compareTo(key);

      if (cmp < 0) {
        low = mid + 1;
      } else if (cmp > 0) {
        high = mid - 1;
      } else {
        return mid; // key found
      }
    }
    return -(low + 1);  // key not found.
  }
}
