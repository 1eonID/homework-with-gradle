package algo;

public class LinkedList<Item> implements List<Item>{
    private int size = 0;
    private Node firstNode;
    private Node lastNode;
    private Node currentElement;
    private boolean finished = false;

    @Override
    public boolean hasNext() {
        if (currentElement == null && finished == false) {
            currentElement = firstNode;
        }
        return currentElement != null;
    }

    @Override
    public Item next() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public Item previous() {
        return null;
    }

    @Override
    public void add(Item item) {
        if (firstNode == null) {
            firstNode = new Node(item);
        } else {
            Node node = firstNode;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(item);
        }

        size++;
    }

    @Override
    public Item get(int index) {
        return null;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    @Override
    public ReverseIterator<Item> reverseIterator() {
        return null;
    }

    private class Node {
        Node(Item value) {
            this.value = value;
        }

        Item value;
        Node next;
        Node previous;
    }
    // your code here

}