package com.giobyte8.psalgo.collections;

import java.util.Objects;

public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T element) {
        Node<T> n = new Node<>(element);

        if (head == null) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }

        size++;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        if (index == size) {
            add(element);
            return;
        }

        Node<T> n = new Node<>(element);
        if (index == 0) {
            n.next = head;
            head = n;
        } else {
            Node<T> prevNode = getNodeAt(index - 1);
            n.next = Objects.requireNonNull(prevNode).next;
            prevNode.next = n;
        }

        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return Objects.requireNonNull(getNodeAt(index)).value;
    }

    public int size() {
        return size;
    }

    private Node<T> getNodeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        if (index == 0) {
            return head;
        }

        if (index == size - 1) {
            return tail;
        }

        Node<T> n = head;
        for (int i = 1; i < size; i++) {
            n = n.next;
            if (i == index) return n;
        }

        return null;
    }

    static class Node<T> {
        Node<T> next;
        T value;

        Node(T value) {
            this.value = value;
        }
    }
}
