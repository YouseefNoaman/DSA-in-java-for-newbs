package com.company;

public class Main {


    /*
     *
     *     This is an implementation of the binary search for an array of integers, both recursively and iteratively
     *     it simply works by dividing the array into to halves, then comparing the middle point to the value we need to search for
     *
     *     if it is found at the middle point, return the index of that point
     *     if the value is bigger than the middle point, then the new starting point of the array will be middle point + 1, and redo the splitting again and repeat the process this means that the whole first half of the array is now discarded
     *     if the value is less than the middle point, then the new ending point will be the middle value, and redo the splitting again and repeat the process this means that the whole second half of the array is now discarded
     *
     *     this algorithm's complexity is O(log n) to the base 2, because it is just dividing the array into 2 halves till it finds the value
     *
     *
     *     A HUGE REQUIREMENT FOR THIS ALGORITHM IS THAT THE ARRAY MUST BE SORTED, OTHER THAN THAT IT WILL NOT WORK CORRECTLY
     *
     */
    public static void main(String[] args) {

        // the array needs to be sorted             // int[] arr = {9, 2, 3, 5, 8, 1, 5, 7, -15};       // this won't work

        int[] arr = {-9, 1, 2, 3, 5, 5, 7, 8, 9};


        // the recursive binary search function call
        System.out.println(recursiveBinarySearch(arr, 7));
        System.out.println(recursiveBinarySearch(arr, 2));
        System.out.println(recursiveBinarySearch(arr, 13));
        System.out.println(recursiveBinarySearch(arr, -9));


        // the recursive binary search function call
        System.out.println(binarySearch(arr, 7));
        System.out.println(binarySearch(arr, 2));
        System.out.println(binarySearch(arr, 13));
        System.out.println(binarySearch(arr, 5));
        System.out.println(binarySearch(arr, 5));
        System.out.println(binarySearch(arr, -15));

    }

    public static int binarySearch(int[] arr, int value) {

        int start = 0;                          // this is the starting point of the array
        int end = arr.length;                   // this is the ending point of the array

        while (start < end) {                   // while the start < end
            int mid = (start + end) / 2;        // the middle point is (start + end) / 2
            if (arr[mid] == value)              // if the middle point of the array IS the searched for value
                return mid;                     // return that value

            else if (arr[mid] < value)          // else if the middle point value is less than the searched for value
                start = mid + 1;                // then the start will be mid + 1 instead of 0, so the whole first half of the array is discarded, that is less than the searched for value

            else                                // other than that, the searched for value is less than the value in the middle point of the array
                end = mid;                      // so the end point will be the middle point, so the whole second half of the array is discarded, that is larger than the searched for value
        }
        return -1;                              // this means that the searched for item is not found
    }

    public static int recursiveBinarySearch(int[] arr, int value) {              // you can use this or the overridden version of it
        return recursiveBinarySearch(arr, 0, arr.length, value);
    }

    public static int recursiveBinarySearch(int[] arr, int start, int end, int value) {
        if (start >= end)                       // if the end point is equal or less than the start point, then the item is not found
            return -1;                          // return -1, means that it is not found

        int mid = (start + end) / 2;            // the middle point will equal (start + end) / 2
        if (arr[mid] == value)                  // if the searched for value equals the middle point in the array
            return mid;                         // then return that value

        else if (arr[mid] < value)                                                  // else if the searched for value is bigger than the middle of the array
            return recursiveBinarySearch(arr, mid + 1, end, value);           // call the function recursively with the new starting point of middle + 1, so the first half of the array is discarded

        else                                                                        // other than that means that the searched for value is less than the middle of the array
            return recursiveBinarySearch(arr, start, mid, value);                   // call the function recursively with the new starting point of middle + 1, so the second half of the array is discarded


    }

}
