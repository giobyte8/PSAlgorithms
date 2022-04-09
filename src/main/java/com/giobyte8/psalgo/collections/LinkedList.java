package com.giobyte8.psalgo.collections;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
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

    @Override
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

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return Objects.requireNonNull(getNodeAt(index)).value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> currNode;

            @Override
            public boolean hasNext() {
                if (currNode == null) {
                    return head != null;
                }

                return currNode.next != null;
            }

            @Override
            public T next() {
                if (currNode == null) {
                    currNode = head;
                } else {
                    currNode = currNode.next;
                }

                return currNode.value;
            }
        };
    }

    @Override
    public void forEachIdx(ConsumerIdx<T> consumer) {
        AtomicInteger atomicIdx = new AtomicInteger(0);
        for (T el : this) {
            consumer.onItem(el, atomicIdx.getAndIncrement());
        }
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
