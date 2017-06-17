import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

public class MyFirstTests {

  // Bitwise

  @Test
   public void testCalcOfAnd() throws Exception {
     String right = "0011";
     String left =  "1111";

     assertThat(BitwiseCalc.and(left, right), is("0011"));
   }

   @Test
   public void testCalcOfOr() throws Exception {
     String left =  "1001";
     String right = "0010";

     assertThat(BitwiseCalc.or(left, right), is("1011"));
   }

   @Test
   public void testCalcOfXor() throws Exception {
     String left =  "0101";
     String right = "1100";

     assertThat(BitwiseCalc.xor(left, right), is("1001"));
   }

   @Test
   public void testCalcOfNot() throws Exception {
     assertThat(BitwiseCalc.not("1110"), is("0001"));
   }

// ArraysCopier
  private ArraysCopier copier;

  @Before
  public void setUp() {
    copier = new ArraysCopier(new int[] {1, 2, 3, 4, 5, 6, 7});
  }

  @Test
  public void copyOfTheSameLengthArray() throws Exception {
    assertThat_CopyOf(7, new int[] {1, 2, 3, 4, 5, 6, 7});
  }

  @Test
  public void copyOfEmptyArray() throws Exception {
    assertThat_CopyOf(0, new int[] {});
  }

  @Test
  public void copyOfBiggerArray() throws Exception {
    assertThat_CopyOf(12, new int[] {1, 2, 3, 4, 5, 6, 7, 0, 0, 0, 0, 0});
  }

  @Test
  public void copyOfSmallerArray() throws Exception {
    assertThat_CopyOf(2, new int[] {1, 2});
  }

  private void assertThat_CopyOf(int newLength, int[] equalsToArray) {
    assertThat(Arrays.equals(copier.copyOf(newLength), equalsToArray), is(true));
  }

  @Test
  public void copyFirstHalfOfArray() throws Exception {
    assertThat_CopyOfRange(0, 4, new int[] {1, 2, 3, 4});
  }

  @Test
  public void copySecondHalfOfArray() throws Exception {
    assertThat_CopyOfRange(5, 7, new int[] {6, 7});
  }

  @Test
  public void copyOneElementOfArray_shouldReturnEmptyArray() throws Exception {
    assertThat_CopyOfRange(5, 5, new int[] {});
  }

  @Test
  public void copyWrongRangeOfArray() throws Exception {
    assertThat(copier.copyOfRange(6, 4), is(nullValue()));
  }

  private void assertThat_CopyOfRange(int from, int to, int[] equalsToArray) {
    assertThat(Arrays.equals(copier.copyOfRange(from, to), equalsToArray), is(true));
  }

  @Test
  public void fillWithZeroValue() {
    assertThat_fillWithValue(0, new int[] {0, 0, 0, 0, 0, 0, 0});
  }

  @Test
  public void fillWithNegativeValue() {
    assertThat_fillWithValue(-4, new int[] {-4, -4, -4, -4, -4, -4, -4,});
  }

  private void assertThat_fillWithValue(int value, int[] equalsToArray) {
    assertThat(Arrays.equals(copier.fill(value), equalsToArray), is(true));
  }






}
