package linkedlist;

public class POBoxLinkedList<T> {

    private final Node<T> head;
    private int size;

    public POBoxLinkedList() {
        head = new Node<>(null);
        size = 0;
    }

    public void add(T data) {
        Node<T> node = new Node<>(data);
        Node<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(node);
        size++;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        Node<T> current = head.getNext();
        String elements = "";
        while (current != null) {
            elements += "[" + current.getData().toString() + "]";
            current = current.getNext();
        }
        return elements;
    }
}
