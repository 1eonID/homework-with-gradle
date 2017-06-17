import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

public class MyTestArrayCopy {
  private ArraysCopier copy;

  @Before
  public void setUp() {
    copy = new ArraysCopier(new int [] {1,2,3,4});
  }

  @Test
  public void coppyWrongSize() throws Exception {
    assertThat(copy.copyOf(-5), is(nullValue()));
  }

  @Test
  public void coppyWrongRange() throws Exception {
    assertThat(copy.copyOfRange(2,5), is(nullValue()));
  }
}
