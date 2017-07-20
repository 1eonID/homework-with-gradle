package algo;

public class BSTMap<K, V> {
  private Node root; //head of our tree

  private class Node<K, V> {
    Node leftChild, rightChild;
    K key;
    V value;
  }

  public V get(K key) {
    Node current = root;
    if (current.key == null) {
      throw NoSuchElementException("Your tree is empty");
    }
    while(current.key != key) {
      if (key < current.key) {
        current = current.leftChild;
      } else {
        current = current.rightChild;
      }
      if (current = null) {
        return null;
      }
    }
    return current.value;
  }

  public void put(K key, V value) {
    Node newElem = new Node();
    newElem.key = key;
    newElem.value = value;
    if (root == null) {
      root = newElem;
    } else {
      Node current = root;
      Node parent;
      while (true) {
        parent = current;
        if (key < current.key) {
          current = current.leftChild;
          if (current == null) {
            parent.leftChild = newEleml;
            return;
          }
        } else {
          current = current.rightChild;
          if (current == null) {
            parent.rightChild = newElem;
            return;
          }
        }
      }
    }
  }

  public void delete(K key) {
    Node current = root;
    if (current.key == null) {
      throw NoSuchElementException("Your tree is empty");
    }
    while (current.key != key) {
      
    }
  }
}
