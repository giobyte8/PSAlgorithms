package com.giobyte8.psalgo;


import java.util.*;

public class DTest {

    static class Person implements Comparable<Person> {
        String name;

        Person(String name) {
            this.name = name;
        }


        @Override
        public int compareTo(Person otherPerson) {
            return this.name.compareTo(otherPerson.name);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;

            Person another = (Person) obj;
            return Objects.equals(name, another.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static void main(String[] args) {
        String foo = "foo";
        if (foo.compareToIgnoreCase(null) == 0) {
            System.out.println("Match");
        }

        System.out.println((int) '`');
    }
}
