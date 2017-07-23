package algo;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BSTMap<K, V> {
  private Node root; //head of our tree

  @SuppressWarnings("unchecked")
  private boolean compare(K k1, K k2) {
    return ((Comparable) k2).compareTo(k1) > 0;
  }

  private class Node {
    Node leftChild;
    Node rightChild;
    K key;
    V value;
  }

  public V get(K key) {
    Node current = root;
    if (current.key == null) {
      throw new NoSuchElementException("Your tree is empty");
    }
    while (current.key != key) {
      if (compare(key, current.key)) {
        current = current.leftChild;
      } else {
        current = current.rightChild;
      }
      if (current == null) {
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
        if (compare(key, current.key)) {
          current = current.leftChild;
          if (current == null) {
            parent.leftChild = newElem;
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
    Node parent = root;
    boolean isLeftChild = true; //This variable is needed to determine the direction of our search
    if (current.key == null) {
      throw new NoSuchElementException("This tree is empty");
    }
    while (current.key != key) {
      parent = current;
      if (compare(key, current.key)) {
        isLeftChild = true;
        current = current.leftChild;
      } else {
        isLeftChild = false;
        current = current.rightChild;
      }
      if (current == null) {
        throw new NoSuchElementException("No such element in this tree");
      }
    }
    // In a situation where our removed node does not have any children:
    if (current.leftChild == null && current.rightChild == null) {
      if (current == root) {
        root = null;
      } else if (isLeftChild) {
        parent.leftChild = null;
      } else {
        parent.rightChild = null;
      }
    } else if (current.rightChild == null) {
      // In a situation where our removed node have one LEFT child
      if (current == root) {
        root = current.leftChild;
      } else if (isLeftChild) {
        parent.leftChild = current.leftChild;
      } else {
        parent.rightChild = current.leftChild;
      }
    } else if (current.leftChild == null) {
      // In a situation where our removed node have one RIGHT child
      if (current == root) {
        root = current.rightChild;
      } else if (isLeftChild) {
        parent.leftChild = current.rightChild;
      } else {
        parent.rightChild = current.rightChild;
      }
    } else {
      // In a situation where our removed node have LEFT and RIGHT child
      Node nextNode = nextNode(current);
      if (current == root) {
        root = nextNode;
      } else if (isLeftChild) {
        parent.leftChild = nextNode;
      } else {
        parent.rightChild = nextNode;
      }
      // And now successor connected with the left child of our removed node.
      nextNode.leftChild = current.leftChild;
    }
  }

  //This method need to search successor of our removed node, only when removed node
  //has left and right child
  private Node nextNode(Node removedNode) {
    Node nextNodeParent = removedNode;
    Node nextNode = removedNode;
    //first and final jump to right child, because successor of our removed node can't
    //be less than removed node in this situation with left and right children, so
    //first step - jump to right child of our removed node
    //and second step - then we will seek only left children
    Node current = removedNode.rightChild;
    while (current != null) {
      nextNodeParent = nextNode;
      nextNode = current;
      current = current.leftChild;
    }
    if (nextNode != removedNode.rightChild) {
      nextNodeParent.leftChild = nextNode.rightChild;
      nextNode.rightChild = removedNode.rightChild;
    }
    return nextNode;
  }

  //Method for searching node with minimal key
  public Node min() {
    Node current = root;
    Node last = root;
    while (current != null) {
      last = current;
      current = current.leftChild;
    }
    return last;
  }

  //Method for searching node with maximum key
  public Node max() {
    Node current = root;
    Node last = root;
    while (current != null) {
      last = current;
      current = current.rightChild;
    }
    return last;
  }

  //
  private void order(Node current) {
    if (current != null) {
      order(current.leftChild);
      order(current.rightChild);
    }
  }

  public Iterator<K> iterator() {
    return new Iterator<K>() {

      private Node current;

      public boolean hasNext() {
        return (current != null);
      }

      public K next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        current = min();
        K tmp = current.key;
        delete(current.key);
        return tmp;
      }
    };
  }
}
