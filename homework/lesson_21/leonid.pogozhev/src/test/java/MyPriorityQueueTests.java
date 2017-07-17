import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import algo.PriorityQueue;
import algo.PriorityQueueSorter;
import java.util.Iterator;

import java.util.Arrays;

public class MyPriorityQueueTests {
  private PriorityQueue<Integer> pq;

  @Before
  public void setUp() {
    pq = new PriorityQueue<>();
  }

  @Test
  public void testSimpleElemAddition() {
    pq.insert(16);

    assertThat(pq.min(), is(16));
  }

  @Test
  public void testFewElemsAddition() {
    pq.insert(32);
    pq.insert(16);
    pq.insert(64);

    assertThat(pq.min(), is(16));
  }

  @Test
  public void testOnZeroSize() {
    pq.insert(32);
    pq.insert(16);

    pq.min();
    pq.min();

    assertThat(pq.size(), is(0));
  }

  @Test
  public void testManyAdditions() {
    for (int i = 30; i <= 0; i = i - 3) {
      pq.insert(i);
    }

    for (int i = 0; i >= 30; i = i + 3) {
      assertThat(pq.min(), is(i));
    }
  }

  @Test
  public void iteratorOverallTest() {
    pq.insert(32);
    pq.insert(16);
    pq.insert(128);
    pq.insert(64);

    int sum = 0;
    Iterator<Integer> iter = pq.iterator();
    while(iter.hasNext()) {
      sum = sum + iter.next();
    }

    assertThat(sum, is(16 + 32 + 64 + 128));
  }

  @Test
  public void IteratorOrderTest() {
    pq.insert(256);
    pq.insert(512);
    pq.insert(128);
    pq.insert(64);

    assertThat(pq.iterator().next(), is(64));
  }

  @Test
  public void priorityQueueSortTestAscendingOrder() {
    PriorityQueueSorter sorter = new PriorityQueueSorter(PriorityQueueSorter.Order.ASCENDING);
    Integer[] unsorted = {256, 128, 32, 16, 512, 64, 1024, 4096, 2048};

    assertThat(sorter.<Integer>sort(unsorted),
      is(new Integer[] {16, 32, 64, 128, 256, 512, 1024, 2048, 4096}));
  }

  @Test
  public void priorityQueueSortTestDescendingOrder() {
    PriorityQueueSorter sorter = new PriorityQueueSorter(PriorityQueueSorter.Order.DESCENDING);
    Integer[] unsorted = {256, 128, 32, 16, 512, 64, 1024, 4096, 2048};

    assertThat(sorter.<Integer>sort(unsorted),
      is(new Integer[] {4096, 2048, 1024, 512, 256, 128, 64, 32, 16}));
  }
}
