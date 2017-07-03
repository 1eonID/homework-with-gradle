import org.junit.Test;
import org.junit.Before;

import algo.queue.LinkedListQueue;
import algo.queue.Iterator;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class LinkedListQueueTests {
  private LinkedListQueue<String> queue;

  @Before
  public void setUp() {
    queue = new LinkedListQueue<>();
  }

  @Test
  public void test_simpleAddition() {
    queue.enqueue("10");

    assertThat(queue.dequeue(), is("10"));
  }

  @Test
  public void test_moreElementsAddition() {
    queue.enqueue("10");
    queue.enqueue("20");
    queue.enqueue("30");

    assertThat(queue.dequeue(), is("10"));
    assertThat(queue.dequeue(), is("20"));
    assertThat(queue.dequeue(), is("30"));
  }

  @Test
  public void test_size_whenOneElemExist() {
    queue.enqueue("10");

    assertThat(queue.size(), is(1));
  }

  @Test
  public void test_size_whenThreeElemExist() {
    queue.enqueue("10");
    queue.enqueue("20");
    queue.enqueue("30");

    assertThat(queue.size(), is(3));
  }

  @Test
  public void test_size_whenDequeueIsCalled() {
    queue.enqueue("10");
    queue.enqueue("20");

    queue.dequeue();

    assertThat(queue.size(), is(1));
  }

  @Test
  public void test_initialSize() {
    assertThat(queue.size(), is(0));
  }

  @Test
  public void test_multipleAdditions() {
    for (int i = 0; i < 20; i++) {
      queue.enqueue(Integer.toString(i));
    }
    assertThat(queue.size(), is(20));
  }

  @Test
  public void afterClearMethodCall_sizeShouldEqualZero() {
    queue.clear();

    assertThat(queue.size(), is(0));
  }

  @Test
  public void iteratorOverallTest() {
    LinkedListQueue<Integer> queue = new LinkedListQueue<>();
    queue.enqueue(16);
    queue.enqueue(32);
    queue.enqueue(64);
    queue.enqueue(128);

    int sum = 0;
    Iterator<Integer> iter = queue.iterator();
    while(iter.hasNext()) {
      sum = sum + iter.next();
    }

    assertThat(sum, is(16 + 32 + 64 + 128));
  }

  @Test
  public void IteratorOrderTest() {
    queue.enqueue("16");
    queue.enqueue("32");
    queue.enqueue("64");
    queue.enqueue("128");

    assertThat(queue.iterator().next(), is("16"));
  }
}
