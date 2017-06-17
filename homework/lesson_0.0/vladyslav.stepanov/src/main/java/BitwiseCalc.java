public class BitwiseCalc {

  public static String and(String binaryLeft, String binaryRight) {
    String res = "";
    for (int i = 0; i < binaryLeft.length(); i++ ) {
      if (binaryLeft.charAt(i) == '1' && binaryRight.charAt(i) == '1') {
        res = res + "1";
      } else {
        res = res + "0";
      }
    }
    return res;
  }


  public static String or(String binaryLeft, String binaryRight) {
    String res = "";
    for (int i = 0; i < binaryLeft.length() ;i++ ) {
      if (binaryLeft.charAt(i) == '1' || binaryRight.charAt(i) == '1') {
        res += "1";
      } else {
        res += "0";
      }
    }
    return res;
  }

  public static String xor(String binaryLeft, String binaryRight) {
    String res = "";
    for (int i = 0; i < binaryLeft.length() ;i++ ) {
      if (binaryLeft.charAt(i) == '1' && binaryRight.charAt(i) != '1'
          || (binaryLeft.charAt(i) != '1' && binaryRight.charAt(i) == '1') ) {
        res += "1";
      } else {
        res += "0";
      }
    }
    return res;
  }

  public static String not(String binaryLeft) {
    String res = "";
    for (int i = 0; i < binaryLeft.length() ;i++ ) {
      if (binaryLeft.charAt(i) == '1') {
        res += "0";
      } else {
        res += "1";
      }
    }
    return res;
  }
}
