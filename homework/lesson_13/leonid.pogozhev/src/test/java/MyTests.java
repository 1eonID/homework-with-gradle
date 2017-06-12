import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import algo.BinarySearch;
import algo.BubbleSortBinarySearch;
import algo.SelectionSortBinarySearch;

import java.util.Arrays;

public class MyTests {
  @Test
  public void simpleTest() {
    BinarySearch bin = new BinarySearch() {
      protected Object[] sort(Object[] input) {
        Arrays.sort(input);
        return input;
      }
    };

    SomeObject objectToFind = new SomeObject();
    SomeObject[] objects = {new SomeObject(), objectToFind, new SomeObject()};
    int index = bin.perform(objects, objectToFind);

    assertThat(index, is(1));
  }

  @Test
  public void test_BubbleSortBinarySearch_WithSortedArray() {
    BinarySearch bin = new BubbleSortBinarySearch();

    SomeObject obj1 = new SomeObject();
    SomeObject obj2 = new SomeObject();
    SomeObject obj3 = new SomeObject();

    obj1.value = 5;
    obj2.value = 10;
    obj3.value = 20;

    SomeObject[] objects = {obj1, obj2, obj3};
    int index = bin.perform(objects, obj3);

    assertThat(index, is(2));
  }

  @Test
  public void test_BubbleSortBinarySearch_WithUnSortedArray() {
    BinarySearch bin = new BubbleSortBinarySearch();

    SomeObject obj1 = new SomeObject();
    SomeObject obj2 = new SomeObject();
    SomeObject obj3 = new SomeObject();

    obj1.value = 20;
    obj2.value = 10;
    obj3.value = 30;

    SomeObject[] objects = {obj1, obj2, obj3};
    int index = bin.perform(objects, obj1);

    assertThat(index, is(1));
  }

  @Test
  public void test_SelectionSortBinarySearch_WithUnSortedArray() {
    BinarySearch bin = new SelectionSortBinarySearch();

    SomeObject obj1 = new SomeObject();
    SomeObject obj2 = new SomeObject();
    SomeObject obj3 = new SomeObject();

    obj1.value = 250;
    obj2.value = 10;
    obj3.value = 3000;

    SomeObject[] objects = {obj1, obj2, obj3};
    int index = bin.perform(objects, obj1);

    assertThat(index, is(1));
  }
}
