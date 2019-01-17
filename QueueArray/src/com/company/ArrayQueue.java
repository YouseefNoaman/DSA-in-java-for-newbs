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

    public void add(Employee employee){         // this function is used to add an object to the queue, you need to pass an Employee object as a parameter
        if (back == queue.length){              // if the back pointer reached the end of the array, means if the array is full
            Employee[] newArray = new Employee[2 * queue.length];       // this will double the size of the array
            System.arraycopy(queue, 0, newArray, 0, queue.length);      // this will copy the contents of the old array to the new double length array
            queue = newArray;                   // then the old array (queue) = newArray
        }

        queue[back] = employee;                 // this line will just add the new Employee object to the queue
        back++;                                 // then increment the back
    }

    public Employee remove(){                   // this function is used to remove the object at the front of the queue
        if (size() == 0)                        // this will output an error if the queue is empty
            throw new NoSuchElementException(); // it will throw this error

        Employee employee = queue[front];       // the element at the first position in the queue will be saved into an object
        queue[front] = null;                    // then the position of it in the queue will be null, so its location is now empty
        front++;                                // then increase the front      // this line will make a problem, it will be solved by the circular queue
        if (size() == 0){                       // if the array is empty, this means that you need to reset the pointers of front and back
            front = 0;
            back = 0;
        }
        return employee;
    }

    public Employee peek(){                     // this function is used to return the object at the front of the queue
        if (size() == 0)                        // if the queue is empty return an error message
            throw new NoSuchElementException();

        return queue[front];                    // this will return an item at the front of the queue
    }

    public void printQueue(){                   // this function is used to print out the queue
        for (int i = front; i < back; i++){
            System.out.println(queue[i]);
        }
    }

    public int size(){                          // this is used to return the size of the queue
        return back - front;
    }


}
