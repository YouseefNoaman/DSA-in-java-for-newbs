package com.company;

/*
 *
 *   this is an implementation of a MAX heap
 *   a max heap is about sorting a binary search tree (BST) with the largest value is at the root and smaller values at the children
 *   there is also a min heap, which is the same idea but with the minimum value at the root
 *   this data structure is preferably used when you are interested in changing the root a lot as the better complexities are when minimum fixing heap operations are done, as an example a priority queue
 *
 *   it has a complexity of O(log n) to the base 2 when inserting, delete will be O(n) because we need to find the value first, if there is no index and the deletion is random it will be O(n log(n)) to the base 2 (linear search + fixing the heap)
 *   fixing the heap will be O(n) because maybe we are swapping a node all the way up to the root, getting the maximum in a max heap is O(1), as it is the root
 *
 *   to make this implementation a MIN heap, just change the (larger than) comparison in the fix heap to (smaller than) to compare if the value is smaller than its parent to move it up the heap
 *
 */


public class Heap {

    private int[] Heap;             // the heap will be an array of type int
    private int size;               // this will be its size

    public Heap(int size) {         // a constructor to initialize the heap by giving it the size
        Heap = new int[size];
    }

    public void fixHeapAbove(int index) {               // this function is used to fix the heap, when inserting or deleting, you need to check the above values to check that they are bigger than the value you are currently at
        int newValue = Heap[index];                     // this will save the value that we need to fix the heap above it
        while (index > 0 && newValue > Heap[getParent(index)]) {        // this loop checks if we reached the first index of the array AND if the value is bigger than its parent
            Heap[index] = Heap[getParent(index)];                       // if both conditions are met above, then the value is bigger than its parent, this will swap them
            index = getParent(index);                                   // and this will be the new index of the value
        }                                                               // then the loop will continue till we reach the index of the root, or the value is smaller than the parent, which means that the heap is correct
    }

    public void fixHeapBelow(int index, int lastIndex) {        // this function is like the fux heap above, but this is used to fix the heap below when deleting if the value deleted < its parent, to make the heap a complete tree
        int childToSwap = 0;                                        // this is to hold the child to swap

        while (index <= lastIndex) {                // while the index of the given value <= the index of the heap to fix
            int leftChild = getLeftChild(index);    // get the left and right children of the value
            int rightChild = getRightChild(index);
            if (leftChild <= lastIndex) {           // if the left child <= size of the heap
                if (rightChild > lastIndex)         // if the right child > size of the heap
                    childToSwap = leftChild;        // then the new parent value is the left child
                else                                // else, check which value is bigger, the right child or the left, and it will become the new parent
                    childToSwap = (Heap[leftChild] > Heap[rightChild] ? leftChild : rightChild);

                if (Heap[index] < Heap[childToSwap])      // if the value deleted < the value of the new parent, swap them
                    swap(Heap, index, childToSwap);
                else                                      // other than that break out of these conditions to repeat the process again
                    break;

                index = childToSwap;                      // the new index is the childToSwap
            } else                                          // if the leftChild > lastIndex then break to recheck the loop's condition
                break;
        }
    }

    public void insert(int element) {           // this function is used to insert new values into the heap
        if (isFull())                           // if the heap is full, return that error back
            throw new IndexOutOfBoundsException("Heap is full");

        Heap[size++] = element;                 // other than that, add the element and increase the size
        fixHeapAbove(size);                     // then fix the heap above to check that the added value is smaller than its parent, so it will run on all the heap so give it the size of it
    }

    public int delete(int index) {              // this function deletes a value from the heap given its index
        if (isEmpty())                          // if it is empty, return this error
            throw new IndexOutOfBoundsException("Heap is empty");

        int parent = getParent(index);          // get the parent of the deleted value
        int deletedValue = Heap[index];         // deletedValue will hold the deleted value of the heap

        Heap[index] = Heap[size - 1];           //  when you delete a value in the heap, you always replace it with the bottom right element, which is the last element in the array

        if (index == 0 || Heap[index] < Heap[parent])       // if the deleted index is 0 OR the value at the index < its parent
            fixHeapBelow(index, size - 1);         // fix the heap below
        else
            fixHeapAbove(index);                            // other than that, fix the heap above

        size--;                                             // decrement the size
        return deletedValue;                                // return the deleted value
    }

    public int peek() {              // this function is to peek the heap
        if (isEmpty())              // if it is empty, return this error
            throw new IndexOutOfBoundsException("Heap is empty");
        return Heap[0];             // if not return the root of the heap, which is the first element

    }

    public boolean isFull() {               // this function is used to check if the heap is full
        return size == Heap.length;         // if the heap equals the size of the array, then it is full
    }

    public boolean isEmpty() {              // this function is used to check if the heap is empty
        return size == 0;                   // if the size of the array equals 0, then it is empty
    }

    public void printHeap() {                    // this function is used to print the heap
        for (int i = 0; i < size; i++) {        // this is a simple for loop to print an array
            System.out.print(Heap[i] + ", ");
        }
        System.out.println();
    }

    public void sort() {                    // this is an implementation of the heap sort, it has a complexity of O(n log n) to the base 2, as it has to compare and then fix the heap
        int lastIndex = size - 1;           // this is used to hold the size

        for (int i = 0; i < lastIndex; i++) {       // this loop is used to traverse the heap
            swap(Heap, 0, lastIndex - i);     // this will swap the root and the last element that is being sorted ( means - i), the root here is the biggest element, that's why it is swapped to be the last element
                                                    // so it will sort the heap again but without the last element, as it is the largest, then it moves the second largest element next to it and resorts it again
            fixHeapBelow(0, lastIndex - i - 1);     // this is used to heapify the heap again without the largest elements, to make the next biggest element is the new root
        }
    }

    public void swap(int[] arr, int i, int j) {     // this function is used to swap 2 numbers in an array
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int getParent(int index) {                               // this is used to get the parent of a given node in the heap
        return (int) (Math.floor((index - 2) / 2));                 // the equation = floor(index - 2) / 2
    }

    public int getLeftChild(int index) {                            // this is used to get the left child of a given node in the heap
        return (2 * index + 1);                                     // left child = 2 * index + 1
    }

    public int getRightChild(int index) {                           // this is used to get the right child of a given node in the heap
        return (2 * index + 2);                                     // right child = 2 * index + 2
    }

        /*public int getChild(int element, boolean which) {             // another function to get the left and right child
        return 2 * element + (which ? 1 : 2);
    }*/

}
