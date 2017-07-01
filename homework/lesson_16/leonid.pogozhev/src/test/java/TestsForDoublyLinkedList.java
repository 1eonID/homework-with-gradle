import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import algo.*;

public class TestsForDoublyLinkedList {
  private List<Integer> list;

  @Before
  public void setUp() {
    list = new LinkedList<>();

    list.add(16);
    list.add(32);
    list.add(64);
    list.add(128);
    list.add(256);
  }

  @Test
  public void testFetchingElementsByIndex() {

    assertThat(list.get(0), is(16));
    assertThat(list.get(4), is(256));
  }

  @Test
  public void testInsertion_thenGetOfThirdElem() {
    assertThat(list.get(2), is(64));
  }

  @Test
  public void removalElementInTheMiddle() {
    list.remove(1);
    list.remove(2);
    list.remove(1);

    assertThat(list.get(0), is(16));
    assertThat(list.get(1), is(256));
  }

  @Test
  public void removalLastTwoElements_returnZeroSize() {
    for (int i = 0; i < 5; i++) {
      list.remove(0);
    }

    assertThat(list.size(), is(0));
  }

  @Test
  public void onEmptyList_isEmpty_returnsTrue() {
    List<Integer> list = new LinkedList<>();

    assertThat(list.isEmpty(), is(true));
  }

  @Test
  public void onNonEmptyList_isEmpty_returnsFalse() {
    List<Integer> list = new LinkedList<>();
    list.add(16);

    assertThat(list.isEmpty(), is(false));
  }

  @Test
  public void afterClearMethodCall_sizeShouldEqualZero() {
    list.clear();

    assertThat(list.size(), is(0));
  }

  @Test
  public void iteratorOverallTest() {
    List<Integer> list = new LinkedList<>();
    list.add(16);
    list.add(32);
    list.add(64);

    int sum = 0;
    Iterator<Integer> iter = list.iterator();
    while(iter.hasNext()) {
      sum = (sum + iter.next()) - 10;
    }

    assertThat(sum, is((16 + 32 + 64) - 30));
  }

  @Test
  public void reverseIteratorOverallTest() {
    List<Integer> list = new LinkedList<>();
    list.add(16);
    list.add(16);
    list.add(32);

    int zeroSum = 64;
    ReverseIterator<Integer> iter = list.reverseIterator();
    while(iter.hasPrevious()) {
      zeroSum -= iter.previous();
    }

    assertThat(zeroSum, is(32 - 16 - 16));
  }

  @Test
  public void IteratorOrderTest() {
    List<Integer> list = new LinkedList<>();
    list.add(16);
    list.add(32);

    assertThat(list.iterator().next(), is(16));
  }

  @Test
  public void reverseIteratorTest() {
    List<Integer> list = new LinkedList<>();
    list.add(32);
    list.add(64);
    list.add(128);

    assertThat(list.reverseIterator().previous(), is(128));
  }
}
