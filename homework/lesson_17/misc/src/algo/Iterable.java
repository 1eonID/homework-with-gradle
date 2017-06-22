package algo;

public interface Iterable<Item> {
  Iterator<T> iterator();
  ReverseIterator<T> reverseIterator();
}
