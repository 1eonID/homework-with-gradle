import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class SimStrCalcTest {
  private  SimpleStringCalculator str = new SimpleStringCalculator();

  @Test
  public void emptyStringTest() throws Exception {
    String tmp = "";

    assertThat(str.add(tmp), is(0));
  }

  @Test
  public void manyNumbersTest() throws Exception {
    String tmp = "1+2+3+4+5+6+7+8+9+10+11+12";

    assertThat(str.add(tmp), is(78));
  }

  @Test
  public void anySymbolTest() throws Exception {
    String tmp = "&1#2+3+4";

    assertThat(str.add(tmp), is(10));
  }

  @Test
  public void negativeNumTest1() throws Exception {
    String tmp = "1-+2+3+4";

    assertThat(str.add(tmp), is(10));
  }

  @Test
  public void negativeNumTest2() throws Exception {
    String tmp = "1-2+3+4";

    assertThat(str.add(tmp), is(-1));
  }

  @Test
  public void negativeNumTest3() throws Exception {
    String tmp = "-1+2+3+4";

    assertThat(str.add(tmp), is(-1));
  }

  @Test
  public void notBigNumTest() throws Exception {
    String tmp = "1+2+1000+4";

    assertThat(str.add(tmp), is(1007));
  }

  @Test
  public void veryBigNumTest() throws Exception {
    String tmp = "1+2+3+2000";

    assertThat(str.add(tmp), is(6));
  }
}
