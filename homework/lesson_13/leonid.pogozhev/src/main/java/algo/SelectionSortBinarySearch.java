package algo;

public class SelectionSortBinarySearch extends BinarySearch {
  protected Object[] sort(Object[] unsorted) {
    Object[] arr = unsorted;
    for (int i = 0; i < arr.length; i++) {
      /*Предполагаем, что первый элемент (в каждом
      подмножестве элементов) является минимальным */
      Comparable min = (Comparable)arr[i];
      int imin = i; 
      /*В оставшейся части подмножества ищем элемент,
      который меньше предположенного минимума*/
      for (int j = i + 1; j < arr.length; j++) {
        Comparable val = (Comparable)arr[j];
        //Если находим, запоминаем его индекс
        if (val.compareTo(min) > 0) {
          min = val;
          imin = j;
        }
      }
      /*Если нашелся элемент, меньший, чем на текущей позиции,
      меняем их местами*/
      if (i != imin) {
        Object tmp = arr[i];
        arr[i] = arr[imin];
        arr[imin] = tmp;
      }
    }
    return arr;
  }
}