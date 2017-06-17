class ArraysCopier {
  int [] array;

  ArraysCopier(int [] array) {
    this.array = array;
  }

  public int [] copyOf(int newLength) {
    int [] newArray;
    if (newLength < 0) {
      newArray = null;
    } else {
      newArray = new int [newLength];
      for (int i = 0; i < newLength; i++) {
        if (i < array.length) {
          newArray[i] = array[i];
        } else {
          newArray[i] = 0;
        }
      }
    }
    return newArray;
  }

  public int [] copyOfRange(int from, int to) {
    int [] newArray;
    try {
      newArray = new int[to - from];
    } catch (NegativeArraySizeException ex) {
      newArray = null;
    }
    try {
      for (int i = from; i < to; i++) {
        newArray[i - from] = array[i];
      }
    } catch (ArrayIndexOutOfBoundsException ex) {
      newArray = null;
    }
    return newArray;
  }

  public int[] fill(int value) {
    int [] newArray = new int [array.length];
    for (int i = 0; i < newArray.length; i++) {
      newArray[i] = value;
    }
    return newArray;
  }
}
