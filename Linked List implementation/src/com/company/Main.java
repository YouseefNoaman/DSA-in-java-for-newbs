package com.company;

/*
 *
 *           this is a simple project on implementing a simple linked list
 *           and implementing the functions add to front, remove from front, size, print list, and is empty
 *
 */

public class Main {

    public static void main(String[] args) {

        // we need first to create objects to add them to the list
        // they will be added to the front, so the first employee will be last
        // and the fifth employee will be last, so the head will point to the fifth node and the first node will point to tail


        Employee first = new Employee(99, "jane", "jones");
        Employee second = new Employee(23, "calvin", "hugo");
        Employee third = new Employee(47, "jack", "mike");
        Employee fourth = new Employee(61, "adams", "harry");
        Employee fifth = new Employee(50, "joly", "philly");

        EmployeeLinkedList LinkedList = new EmployeeLinkedList(); // this line is creating the linked list object

        // these lines are adding the objects to the list in order
        LinkedList.addToFront(first);
        LinkedList.addToFront(second);
        LinkedList.addToFront(third);
        LinkedList.addToFront(fourth);
        LinkedList.addToFront(fifth);

        // this line is printing out the list
        LinkedList.printList();
        // this prints out the size of the list
        System.out.println(LinkedList.getSize());

        // this line checks if the list is empty or not
        System.out.println(LinkedList.isEmpty());

        // this line removes the object that the head is pointing at, which is the last element that was added
        LinkedList.removeFromFront();

        LinkedList.printList();
    }
}
