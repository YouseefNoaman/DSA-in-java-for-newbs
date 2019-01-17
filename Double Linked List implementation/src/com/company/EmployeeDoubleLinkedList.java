package com.company;

/*
 *
 *   this class has the functionality functions of the double linked list
 *
 */

public class EmployeeDoubleLinkedList {
    private EmployeeNode head;  // this is used to hold the pointer to the next node
    private EmployeeNode tail;  // this is used to hold the pointer to the previous node
    private int size;           // this is used to keep track of the size


    public void addToFront(Employee employee) {      // this function is used to add the object to the front of the list, you need to pass an employee object to be added
        EmployeeNode employeeNode = new EmployeeNode(employee);     // this will create a node with the object as its value part

        if (head == null)               // if the head is null, means that if the list is empty, the tail will be the new value node
            tail = employeeNode;
        else {
            // to clarify the next 2 lines, those mean that now the head and employeeNode are pointing to each other
            // employeeNode(set next) <-> head (set previous), then it will make the employeeNode the new head in the line after the else

            head.setPrev(employeeNode);                     // if the list is not empty, make the head point the previous pointer to the new value node
            employeeNode.setNext(head);                     // this line is to attach newly added node's next pointer to the head
        }
        head = employeeNode;                                // now the new added node is the new head
        size++;                                             // increment the size because now a new node is added
    }

    public void addToEnd(Employee employee) {       // this function is used to add the object to the back of the list, you need to pass an employee object to be added
        EmployeeNode employeeNode = new EmployeeNode(employee);
        if (tail == null)           // if the tail is null, means that if the list is empty, the head will be the new value node
            head = employeeNode;
        else {
            // to clarify the next 2 lines, those mean that now the tail and employeeNode are pointing to each other
            // tail (set next) <-> employeeNode (set previous), then it will make the employeeNode the new head in the line after the else

            tail.setNext(employeeNode);                     // if the list is not empty, make the tail point the next pointer to the new value node
            employeeNode.setPrev(tail);                     // this line is to attach newly added node's previous pointer to the tail
        }
        tail = employeeNode;                                // this means the new node is the new tail
        size++;                                             // increment the size because now a new node is added
    }

    public EmployeeNode removeFromFront() {                  // this function is used to remove an employee from the front
        if (isEmpty())                       // if the list is empty, nothing will happen
            return null;

        EmployeeNode removedNode = head;    // save the node in a variable named removedNode

        if (head.getNext() == null)         // this means if the head's next pointer == null when it is the last element in the list, which explains why its getNext() == null
            tail = null;                    // it will assign the tail to null to disconnect it from the list

        else                                // if there are other items in the list
            head.getNext().setPrev(null);   // head.getNext() will be executed first, it will return the pointer to the next node, then it will setPrev() to null, this will simply get the pointer to the next node, then assign the previous pointer of it to null, to break the connection of the node to the list

        head = head.getNext();              // now the head = the pointer of the next object
        size--;                             // decrement the size, because an item is deleted
        removedNode.setNext(null);          // now the item's setNext() is pointing to null, so it got disconnected from the list from the setNext() pointer

        return removedNode;                 // now return back the value of the node
    }

    public EmployeeNode removeFromEnd() {                   // this function is used to remove an employee from the front
        if (isEmpty())                      // if the list is empty, nothing will happen
            return null;

        EmployeeNode removedNode = tail;    // save the node in a variable named removedNode

        if (tail.getPrev() == null)         // this means if the tail's previous pointer == null when it is the last element in the list, which explains why its getPrev() == null
            head = null;                    // it will assign the head to null to disconnect it from the list

        else                                // if there are other items in the list
            tail.getPrev().setNext(null);   // tail.getPrev() will be executed first, it will return the pointer to the previous node, then it will setNext() to null, this will simply get the pointer to the previous node, then assign the next pointer of it to null, to break the connection of the node to the list

        tail = tail.getPrev();          // now the tail = the pointer of the previous object
        size--;                         // decrement the size, because an item is deleted
        removedNode.setPrev(null);      // now the item's setNext() is pointing to null, so it got disconnected from the list from the setNext() pointer

        return removedNode;             // now return back the value of the node
    }

    public void printList() {            // this is used to print out the list
        EmployeeNode current = head;    // you make a variable = head, to use it to traverse the list
        System.out.print("HEAD -> ");
        while (current != null) {         // if the object is not null, means that it is not the last one
            System.out.print(current.getEmployee());    // print the contents of the node in the list
            System.out.print(" <-> ");
            current = current.getNext();            // then assign the node to the next item in the list
        }
        System.out.println("end");
    }

    public int getSize() {      // this function is used to return the size variable, there is no setter for this variable because we don't want to manipulate the variable by hand
        return size;
    }

    public boolean isEmpty() {      // this function checks if the list is populated or not, if the head is pointing at nothing, then it is empty
        return (head == null);
    }


}
