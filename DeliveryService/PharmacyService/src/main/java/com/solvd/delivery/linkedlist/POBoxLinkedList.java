package com.solvd.delivery.linkedlist;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class POBoxLinkedList<T> {

    final static Level MENU_LOG = Level.forName("MENU_LOG", 700);
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");

    private Node<T> head;
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

    public void remove(T key)
    {

        // Dummy node with null value
        Node<T> prev = new Node<>(null);

        // Dummy node pointing to head node
        prev.next = head;

        // Next node that points ahead of current node
        Node<T> next = head.next;

        // Temporary node for traversal
        Node<T> temp = head;

        // Boolean value that checks whether value to be
        // deleted exists or not
        boolean exists = false;

        // If head node needs to be deleted
        if (head.data == key) {
            head = head.next;

            // Node to be deleted exists
            exists = true;
        }

        // Iterating over LinkedList
        while (temp.next != null) {

            // We convert value to be compared into Strings
            // and then compare using
            // String1.equals(String2) method

            // Comparing value of key and current node
            if (String.valueOf(temp.data).equals(
                    String.valueOf(key))) {

                // If node to be deleted is found previous
                // node now points to next node skipping the
                // current node
                prev.next = next;
                // node to be deleted exists
                exists = true;

                // As soon as we find the node to be deleted
                // we exit the loop
                break;
            }

            // Previous node now points to current node
            prev = temp;

            // Current node now points to next node
            temp = temp.next;

            // Next node points the node ahead of current
            // node
            next = temp.next;
        }

        // Comparing the last node with the given key value
        if (!exists
                && String.valueOf(temp.data).equals(
                String.valueOf(key))) {

            // If found , last node is skipped over
            prev.next = null;

            // Node to be deleted exists
            exists = true;
        }

        // If node to be deleted exists
        if (exists) {

            // Size of LinkedList reduced
            size--;
        }

        // If node to be deleted does not exist
        else {
            // Print statement
            LOGGER.log(MENU_LOG, "Given value is not present in linked list");
        }
    }

    public void clear()
    {

        // Head now points to null
        head = null;
        // length is 0 again
        size = 0;
    }

    public boolean empty()
    {

        // Checking if head node points to null
        if (head == null) {
            return true;
        }
        return false;
    }


    public int getSize() {
        return size;
    }

    public String toString() {
        Node<T> current = head.getNext();
        String elements = "";
        while (current != null) {
            elements += "[" + current.getData().toString() + "]\n";
            current = current.getNext();
        }
        return elements;
    }
}
