package com.giobyte8.psalgo.collections.printable;

import com.giobyte8.psalgo.collections.LinkedList;
import com.giobyte8.psalgo.collections.List;

import java.util.Iterator;

public class PLinkedList<T> implements List<T>, PrintableCollection {

    private final LinkedList<T> list;

    public PLinkedList() {
        this.list = new LinkedList<>();
    }

    public PLinkedList(LinkedList<T> list) {
        this.list = list;
    }

    @Override
    public void add(T element) {
        list.add(element);
    }

    @Override
    public void add(int index, T element) {
        list.add(index, element);
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public void forEachIdx(ConsumerIdx<T> consumer) {
        list.forEachIdx(consumer);
    }

    @Override
    public String toPrintableString() {
        int lineMaxLength = 80;
        String nArrow = " -> ";
        String bArrow = " ↴ ";
        String cArrow = " ↳ ";

        StringBuilder lineBuilder = new StringBuilder();
        int freeSpace = lineMaxLength;

        for (int i = 0; i < list.size(); i++) {
            String el = list.get(i).toString();
            int elLength = el.length();

            // Compute required space for this element
            int reqSpace = el.length();
            if (i > 0) {
                reqSpace += freeSpace == lineMaxLength
                        ? cArrow.length()
                        : nArrow.length();
            }
            if (i < list.size() - 1) {
                reqSpace += nArrow.length();
            }

            // If there is not enough space in current line
            if (freeSpace < reqSpace) {

                // If list item can fit into its own line,
                // fill current line with dashes and go to next line
                if (lineMaxLength - bArrow.length() - cArrow.length() >= elLength) {

                    // Always there will be at least bArrow.length + 1 spaces (?)
                    lineBuilder.append(" ");
                    freeSpace--;

                    while (freeSpace > bArrow.length()) {
                        lineBuilder.append('-');
                        freeSpace--;
                    }

                    lineBuilder.append(bArrow).append("\n");
                    freeSpace = lineMaxLength;
                }
            }

            // Add connector from previous element to current one
            if (i > 0) {
                if (freeSpace == lineMaxLength) {
                    lineBuilder.append(cArrow);
                    freeSpace -= cArrow.length();
                } else {
                    lineBuilder.append(nArrow);
                    freeSpace -= nArrow.length();
                }
            }

            // Add each element character one by one
            for (int j = 0; j < el.length(); j++) {
                if (freeSpace == 0) {
                    lineBuilder.append("\n");
                    freeSpace = lineMaxLength;
                }

                lineBuilder.append(el.charAt(j));
                freeSpace--;
            }

            // Add line break if necessary
            if (freeSpace == 3) {
                lineBuilder.append(bArrow).append("\n");
                freeSpace = lineMaxLength;
            }
        }

        return lineBuilder.toString();
    }
}
