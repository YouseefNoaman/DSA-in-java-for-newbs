package com.company;

public class Main {

    public static void main(String[] args) {
        Heap heap = new Heap(10);           // this is used to create a heap and initialize it by size 10 (calling the constructor and passing 10)

        heap.insert(80);        // this will be the root at index 0
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.printHeap();

        System.out.println(heap.delete(1));     // this will delete 75, then it will fix below
        heap.printHeap();
        System.out.println(heap.peek());              // this will return the root of the heap, the first element

        heap.printHeap();                             // this will print the heap before sorting
        heap.sort();                                  // this will use heap sort to sort the heap
        heap.printHeap();                             // this will print out the heap after sorting

    }
}
