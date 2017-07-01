package algo;

public interface List<U> {

  void add(U item);

  U get(int index);

  void remove(int index);

  boolean isEmpty();

  int size();

  void clear();

  Iterator<U> iterator();

  ReverseIterator<U> reverseIterator();

}
