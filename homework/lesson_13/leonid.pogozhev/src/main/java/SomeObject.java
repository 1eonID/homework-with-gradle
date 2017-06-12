public class SomeObject implements Comparable {
  int value;

  @Override
  public int compareTo(Object obj) {
    SomeObject some = (SomeObject) obj;
    return Integer.compare(value, some.value);
  }
}
