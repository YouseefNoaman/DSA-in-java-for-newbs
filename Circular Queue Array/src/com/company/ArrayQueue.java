package com.company;

import java.util.NoSuchElementException;

/*
 *
 *       this is a simple implementation of a regular queue, every operation is O(1), but when resizing the array if it is full it will be O(n)
 *       this algorithm is a FIFO (first in first out), means that the items in the front of the queue will be removed or peeked at first till you reach the back
 *
 * */

public class ArrayQueue {

    private Employee[] queue;       // this is the queue array of type Employee
    private int front;              // this is a pointer to point at the index that holds the value at the front
    private int back;               // this is a pointer to point at the index that holds the value at the back

    public ArrayQueue(int size) {   // this is a constructor that takes a size to initialize the queue of type Employee
        queue = new Employee[size];
    }

    public void add(Employee employee) {         // this function is used to add an object to the queue, you need to pass an Employee object as a parameter
        if (size() == queue.length - 1) {       // because this is a circular queue, this checks if the queue is full

            int numItems = size();              // this is a variable that stores the size, will be used later

            Employee[] newArray = new Employee[2 * queue.length];       // this will double the size of the array

            // the next 2 lines are used to re-sort the queue if it has an overlapped front when it is full
            System.arraycopy(queue, front, newArray, 0, queue.length - front);  // this line will copy the elements from the front to the queue's length - front
            System.arraycopy(queue, 0, newArray, queue.length - front, back);   // this will copy the rest of the queue from 0 to the back pointer

            queue = newArray;                   // then the old array (queue) = newArray

            // now the next 2 lines will redirect the 2 pointers to their original positions, front will be at 0, and the back will be at the end of the array, preserved by numItems
            front = 0;
            back = numItems;

        }

        queue[back] = employee;                 // this line will just add the new Employee object to the queue

        if (back < queue.length - 1)            // if the element that is saved has space behind it, not the last element in the queue, increment the back
            back++;
        else
            back = 0;                           // if not then the back pointer will overlap and be at position 0
    }

    public Employee remove() {                   // this function is used to remove the object at the front of the queue
        if (size() == 0)                        // this will output an error if the queue is empty
            throw new NoSuchElementException(); // it will throw this error

        Employee employee = queue[front];       // the element at the first position in the queue will be saved into an object
        queue[front] = null;                    // then the position of it in the queue will be null, so its location is now empty
        front++;                                // then increase the front      // this line will make a problem, it will be solved by the circular queue
        if (size() == 0) {                       // if the array is empty, this means that you need to reset the pointers of front and back
            front = 0;
            back = 0;
        } else if (front == queue.length) {         // this checks if the front has reached the end of the queue, then it will make it return back to the front of it
            front = 0;
        }
        return employee;
    }

    public Employee peek() {                     // this function is used to return the object at the front of the queue
        if (size() == 0)                        // if the queue is empty return an error message
            throw new NoSuchElementException();

        return queue[front];                    // this will return an item at the front of the queue
    }

    public void printQueue() {                   // this function is used to print out the queue

        if (front <= back) {                    // if the front <= back, just print it out as usual
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        } else {                                // but if the back overlapped the front, then we'll print out the two parts of the circular queue
            for (int i = front; i < queue.length; i++) {        // the first part is from the front to the end of the queue
                System.out.println(queue[i]);
            }
            for (int i = 0; i < back; i++) {                    // the second part will be from 0 to the back pointer, as the back has overlapped
                System.out.println(queue[i]);
            }
        }
    }

    public int size() {                          // this is used to return the size of the queue
        if (front <= back)                       // if the front is before the back and hasn't overlapped, the size will be back - front
            return back - front;
        else                                     // if it has overlapped, the size will be the back - front (a negative number) + queue's length
            return back - front + queue.length;
    }


}
