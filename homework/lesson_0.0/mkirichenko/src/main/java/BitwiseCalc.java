class BitwiseCalc {
  public static String and(String left,String right) {
    int diff = left.length() - right.length();
    if (diff > 0) {
      right = newBinary(right,diff);
    } else if (diff < 0) {
      left = newBinary(left,-diff);
    }
    String result = "";
    for (int i = 0; i < left.length(); i++) {
      if (left.charAt(i) == '1' && (right.charAt(i) == '1')) {
        result = result + 1;
      } else {
        result = result + 0;
      }
    }
    return result;
  }

  public static String or(String left,String right) {
    int diff = left.length() - right.length();
    if (diff > 0) {
      right = newBinary(right,diff);
    } else if (diff < 0) {
      left = newBinary(left,-diff);
    }
    String result = "";
    for (int i = 0; i < left.length(); i++) {
      if (left.charAt(i) == '1' || (right.charAt(i) == '1')) {
        result = result + 1;
      } else {
        result = result + 0;
      }
    }
    return result;
  }

  public static String xor(String left,String right) {
    int diff = left.length() - right.length();
    if (diff > 0) {
      right = newBinary(right,diff);
    } else if (diff < 0) {
      left = newBinary(left,-diff);
    }
    String result = "";
    for (int i = 0; i < left.length(); i++) {
      if (left.charAt(i) == '1' ^ (right.charAt(i) == '1')) {
        result = result + 1;
      } else {
        result = result + 0;
      }
    }
    return result;
  }

  public static String not(String binary) {
    String result = "";
    for (int i = 0; i < binary.length(); i++) {
      if (binary.charAt(i) == '1' ) {
        result = result + 0;
      } else {
        result = result + 1;
      }
    }
    return result;
  }

  public static String newBinary(String binary, int diff) {
    String newBinary = "";
    for (int i = 0; i < diff; i++) {
      newBinary = newBinary + 0;
    }
    newBinary = newBinary + binary;
    return newBinary;
  }
}
