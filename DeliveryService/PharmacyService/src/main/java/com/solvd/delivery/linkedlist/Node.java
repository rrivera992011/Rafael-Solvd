package com.solvd.delivery.linkedlist;

public class Node <T>{
    Node<T> next;
    T data;

    public Node(T data) {
        next = null;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(T dataValue) {
        data = dataValue;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> nextValue) {
        next = nextValue;
    }

}
