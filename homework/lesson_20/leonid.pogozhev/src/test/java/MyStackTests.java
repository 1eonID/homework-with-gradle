import org.junit.Test;
import org.junit.Before;

import algo.stack.LinkedListStack;
import algo.stack.Stack;
import algo.stack.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MyStackTests {
  private LinkedListStack<Integer> stack;

  @Before
  public void setUp() {
    stack = new LinkedListStack<>();
  }

  @Test
  public void testSimpleElemAddition() {
    stack.push(16);

    assertThat(stack.pop(), is(16));
  }

  @Test
  public void testFewElemsAdditionAndPop() {
    stack.push(16);
    stack.push(32);

    stack.pop();

    assertThat(stack.pop(), is(16));
  }

  @Test
  public void testOnZeroSize() {
    stack.push(16);
    stack.push(32);

    stack.pop();
    stack.pop();

    assertThat(stack.size(), is(0));
  }

  @Test
  public void testManyAdditions() {
    for (int i = 0; i < 20; i++) {
      stack.push(i);
    }

    for (int i = 19; i >= 0; i--) {
      assertThat(stack.pop(), is(i));
    }
  }

  @Test
  public void iteratorOverallTest() {
    stack.push(16);
    stack.push(32);
    stack.push(64);
    stack.push(128);

    int sum = 0;
    Iterator<Integer> iter = stack.iterator();
    while(iter.hasNext()) {
      sum = sum + iter.next();
    }

    assertThat(sum, is(128 + 64 + 32 + 16));
  }

  @Test
  public void IteratorOrderTest() {
    stack.push(16);
    stack.push(32);
    stack.push(64);
    stack.push(128);

    assertThat(stack.iterator().next(), is(128));
  }
}
