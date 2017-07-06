import org.junit.Before;
import org.junit.Test;

import algo.eval.Expression;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MyExpressionTests {

  private Expression expression;

  @Before
  public void setUp() throws Exception {
    expression = new Expression();
  }

  @Test
  public void testSimpleExpression() throws Exception {

    assertThat(expression.evaluate("(1 - ((2 + 3) * (4 * 5)))"), is(-99.0));
  }

  @Test
  public void testExpressionWithDivision() throws Exception {

    assertThat(expression.evaluate("(1 - ((8 / 2) * (4 / 2)))"), is(-7.0));
  }

  @Test
  public void testExpressionWithDivision2() throws Exception {

    assertThat(expression.evaluate("(1 - (2 / 4))"), is(0.5));
  }

  @Test
  public void testExpressionWithSubstraction() throws Exception {

    assertThat(expression.evaluate("(1 + ((4 - 2) + (4 - 8)))"), is(-1.0));
  }

  @Test
  public void allOperationsTest() throws Exception {

    assertThat(expression.evaluate("(4 + ((4 * 2) / (4 - 8)))"), is(2.0));
  }

  @Test
  public void allOperationsTestWithBiggerNumbers() throws Exception {

    assertThat(expression.evaluate("(16 + 16)"), is(32.0));
    assertThat(expression.evaluate("(40 * 40)"), is(1600.0));
    assertThat(expression.evaluate("(40 - 40)"), is(0.0));
    assertThat(expression.evaluate("(40 / 40)"), is(1.0));

    assertThat(expression.evaluate("(40 + ((40 * 20) / (40 - 80)))"), is(20.0));
  }
}
