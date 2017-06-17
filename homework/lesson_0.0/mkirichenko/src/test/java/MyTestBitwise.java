import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class MyTestBitwise {
  @Test
  public void bitwiseAndWithPaddings() throws Exception {
    String left = "11110101";
    String right = "1111";

    assertThat(BitwiseCalc.and(left, right), is("00000101"));
  }

  @Test
  public void bitwiseAndWithPaddings2() throws Exception {
    String left = "1111";
    String right = "10101010";

    assertThat(BitwiseCalc.and(left, right), is("00001010"));
  }

  @Test
  public void bitwiseOrWithPaddings() throws Exception {
    String left = "11110101";
    String right = "1111";

    assertThat(BitwiseCalc.or(left, right), is("11111111"));
  }

  @Test
  public void bitwiseXorWithPaddings() throws Exception {
    String left = "11110101";
    String right = "1111";

    assertThat(BitwiseCalc.xor(left, right), is("11111010"));
  }
}
