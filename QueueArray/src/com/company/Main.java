package com.company;


/*
 *
 *   this is a simple implementation of a stack using the array, so the complexity is always O(1) except when resizing the array if it is full, it will be O(n)
 *   the stack is LIFO (last in first out), which means that the last item in the stack will be at the top of it
 *
 * */


public class Main {

    public static void main(String[] args) {

        // creating some employees to add them to the stack
        Employee em = new Employee(99, "nana", "kiki");
        Employee kn = new Employee(34, "kalvin", "harris");
        Employee e = new Employee(99, "nono", "kaka");

        // initializing the stack with a size of 10, this calls the constructor and passes 10 as the size
        ArrayQueue queue = new ArrayQueue(10);

        // push() is used to add the employees to the stack
        queue.add(em);
        queue.add(kn);
        queue.add(e);

        // this is used to print out the stack
        queue.printQueue();

        // this shows the item at the top of the stack
        System.out.println("\n" + queue.peek());

        // this removes the item at the top of the stack
        System.out.println("\n" + queue.remove() + "\n");


        queue.printQueue();

        // this shows the stack's size
        System.out.println("\n" + queue.size());

    }
}
