package com.company;

/*
 *
 *   this class has the functionality functions of the linked list
 *
 */

public class EmployeeLinkedList {
    private EmployeeNode head;  // this variable is used to point at next the object
    private int size;           // this is used to keep track of the size of the linked list

    public void addToFront(Employee employee) {      // this function is used to add the object to the front of the list, you need to pass an Employee object as a parameter to be added
        EmployeeNode node = new EmployeeNode(employee);     // this will create a node with the object as its value part (employee will be passed to the constructor of EmployeeNode)
        node.setNext(head);                                 // this line is to point of the head to the newly added object
        head = node;                                        // now the new added node is the new head
        size++;                                             // when a new node is added, increment the size variable
    }

    public EmployeeNode removeFromFront() {                  // this function is used to remove an employee from the front
        if (isEmpty())      // if the list is empty, nothing will happen
            return null;

        EmployeeNode removedNode = head;    // save the node in a variable named removedNode
        head = head.getNext();              // now the head = the pointer of the next object
        size--;                             // decrement the size, because an item is deleted
        removedNode.setNext(null);          // now the item itself is pointing to null, so it got disconnected from the list
        return removedNode;                 // now return back the value of the node
    }

    public void printList() {            // this is used to print out the list
        EmployeeNode current = head;    // you make a variable = head, to use it to traverse the list
        System.out.print("HEAD -> ");
        while (current.getNext() != null) {         // if the object does not point to null, means that it is not the last one
            System.out.print(current.getEmployee());    // print the contents of the node in the list
            System.out.print(" -> ");
            current = current.getNext();            // then assign the node to the next item in the list
        }
        System.out.println("end");
    }

    public int getSize() {      // this function is used to return the size variable
        return size;
    }

    public boolean isEmpty() {      // this function checks if the list is populated or not, if the head is pointing at nothing, then it is empty
        return (head == null);
    }


}
