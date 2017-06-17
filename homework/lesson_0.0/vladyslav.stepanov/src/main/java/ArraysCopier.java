public class ArraysCopier {
  int[] array;

  // constructor, which take
  //array of integers as an argument
  public ArraysCopier(int[] array) {
    this.array = array;
  }

  public int[] copyOf(int newLength) {
    if (newLength == 0) {
      return new int[0];
    }
    if (newLength == array.length) {
      return array;
    }

    int[] newArray = new int[newLength];
    for (int i = 0; i < newLength; i++) {
      newArray[i] = (i < array.length) ? array[i] : 0;
    }
    return newArray;
  } // return array of indicated range

  public int[] copyOfRange(int from, int to) {
    int newLength = to - from;

    if (newLength < 0) {
      return null;
    }

    int[] newArray2 = new int[newLength];
    for (int i = from, newIndex = 0; i < to; i++, newIndex++) {
      newArray2[newIndex] = array[i];
    }
    return newArray2;
  } // return new array starting from element "from" to element "to"

  public int[] fill(int value) {
    int[] newArray3 = new int[array.length];
    for (int i = 0; i < newArray3.length; i++) {
      newArray3[i] = value;
    }
    return newArray3;
  } // return new array filled of value of argument "value"
}
