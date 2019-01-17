package com.company;

/*
 *
 *           this is a simple project on implementing a simple double linked list
 *           and implementing the functions add to front, add to end, remove from front, remove from end, size, print list, and is empty
 *
 */

public class Main {

    public static void main(String[] args) {

        // we need first to create Employee objects to add them to the list
        // they will be added to the front, so the first employee will be last
        // and the fifth employee will be last
        Employee first = new Employee(99, "jane", "jones");
        Employee second = new Employee(23, "calvin", "hugo");
        Employee third = new Employee(47, "jack", "mike");
        Employee fourth = new Employee(61, "adams", "harry");
        Employee fifth = new Employee(50, "joly", "philly");

        EmployeeDoubleLinkedList DoubleLinkedList = new EmployeeDoubleLinkedList(); // this line is creating the linked list object

        // these lines are adding the objects to the list in order
        DoubleLinkedList.addToFront(first);     // in the end of these objects adding, this will be last node in the list
        DoubleLinkedList.addToFront(second);
        DoubleLinkedList.addToFront(third);
        DoubleLinkedList.addToFront(fourth);
        DoubleLinkedList.addToFront(fifth);     // this will be the first node in the list

        // this line is printing out the list
        DoubleLinkedList.printList();

        // this prints out the size of the list
        System.out.println(DoubleLinkedList.getSize());


        Employee kn = new Employee(14, "kane", "nani");     // created a new employee

        DoubleLinkedList.addToEnd(kn);        // this adds the employee to the end of the list

        DoubleLinkedList.printList();
        System.out.println(DoubleLinkedList.getSize());

        DoubleLinkedList.removeFromFront();   // this removes the first node in the list

        DoubleLinkedList.printList();
        System.out.println(DoubleLinkedList.getSize());

        DoubleLinkedList.removeFromEnd();     // this removes the last node in the list

        DoubleLinkedList.printList();
        System.out.println(DoubleLinkedList.getSize());

        // this line checks if the list is empty or not
        System.out.println(DoubleLinkedList.isEmpty());

    }
}
