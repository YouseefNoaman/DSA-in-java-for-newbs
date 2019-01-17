package com.company;

public class Main {

    public static void main(String[] args) {

        // creating some employees to add them to the stack
        Employee em = new Employee(99, "nana", "kiki");
        Employee kn = new Employee(34, "kalvin", "harris");
        Employee e = new Employee(99, "nono", "kaka");

        // initializing the stack
        LinkedStack stack = new LinkedStack();

        // push() is used to add the employees to the stack
        stack.push(em);
        stack.push(kn);
        stack.push(e);

        // this is used to print out the stack
        stack.printStack();

        // this shows the item at the top of the stack
        System.out.println("\n" + stack.peek());

        // this removes the item at the top of the stack
        System.out.println("\n" + stack.pop() + "\n");


        stack.printStack();

    }
}
