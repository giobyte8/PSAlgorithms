package com.giobyte8.psalgo.collections.printable;

public interface PrintableCollection {

    default void print() {
        System.out.println(toPrintableString());
    }

    String toPrintableString();
}
