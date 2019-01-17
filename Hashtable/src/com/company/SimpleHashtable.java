package com.company;

/*
 *
 *      linear probing is done when there is a collision in the hashtable
 *       A collision happens if two different keys or more have the same hash key, which indicates that the hashing function is weak, but collisions will happen eventually
 *       To solve collisions, "open addressing" (closed hashing) is used, it has several methods to deal with collisions, like linear probing, there are other techniques
 *       Linear probing: simply if there is a collision, increment the hashed key by 1, then rehash, each increment is a probe, less probes is better, because less searching time
 *
 *       IMPORTANT PART: Load Factor
 *       load factor = number of items in the table / capacity of the table, = filled locations / size of the hashtable
 *
 *       *high load factor* means that a collision will happen more likely, because the table is almost filled. (increase the table size or use an open addressing technique)
 *
 *       *low load factor* means that most of the hashtable is empty.       (decrease the table size)
 *
 *
 */

import java.util.ListIterator;

public class SimpleHashtable {

    private StoredEmployee[] hashtable;

    public SimpleHashtable() {      // this constructor initializes the hashtable to be of size 10 and of type StoredEmployee

        hashtable = new StoredEmployee[10];
    }

    public void put(String key, Employee employee) {        // this function will add an employee into the hashtable given the key and an Employee object
        int hashedKey = hashKey(key);                       // this will hash the given key
        if (occupied(hashedKey)) {                          // this checks if the hashed key is already occupied, which will make a collision, so to overcome that linear probing will be implemented

            int stopIndex = hashedKey;                      // this is the stopping index that we would stop at in the hashtable when the linear probing is starting
            if (hashedKey == hashtable.length - 1) {        // this means that the hashedKey is at the end of the hashtable
                hashedKey = 0;                              // then it will be reset to the front of the hashtable
            } else {
                hashedKey++;                                // other than that increment the pointer by 1
            }

            // linear probing loop
            while (occupied(hashedKey) && hashedKey != stopIndex) {     // while the hashingkey still couldn't find an empty space to put the Employee in AND the hashedKey does not equal to the stopIndex
                hashedKey = (hashedKey + 1) % hashtable.length;         // then do the linear probing by incrementing the hashedKey and rehashing again
            }
        }

        if (occupied(hashedKey)) {                                      // if there is no space or the loop reached the stopIndex, it will print out this
            System.out.println("Sorry, there's already an employee at position " + hashedKey);
        } else {                                                        // else it will add the employee at the nearest location in the hashtable
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    public Employee get(String key) {                                   // this is used to retrieve the Employee object given the key
        int hashedKey = findKey(key);                                   // this will search for the key to check if it is present in the hashtable
        if (hashedKey == -1) {                                          // this will return null if it is not found
            return null;
        }
        return hashtable[hashedKey].employee;                           // this will return the employee if it is found
    }

    public Employee remove(String key) {        // this function is used to remove an item given its key

        int hashedKey = findKey(key);           // this variable is holding the hashed key that points to the place of the value

        if (hashedKey == -1) {                  // this means that the record is not found, so it returns null
            return null;
        }

        Employee employee = hashtable[hashedKey].employee;      // this variable will hold the value in the hashtable given the hash key
        hashtable[hashedKey] = null;                            // this will make the location of the value = null, AKA delete it from the hashtable


        // the next bit will reorder the hashtable by having a temporary hashtable to hold its values, then resize the original hashtable and put the values in it again to minimize the linear probing

        StoredEmployee[] oldHashtable = hashtable;              // this will copy the hashtable into a new variable named oldHashtable of type StoredEmployee
        hashtable = new StoredEmployee[oldHashtable.length];    // this will resize the hashtable to make it = oldHashtable

        for (int i = 0; i < oldHashtable.length; i++) {         // this loop will input the values back from oldHashtable into hashtable
            if (oldHashtable[i] != null) {
                put(oldHashtable[i].key, oldHashtable[i].employee);
            }
        }

        return employee;                                        // this will return the employee that got deleted if it is found
    }

    private int hashKey(String key) {           // this hashing function is bad, it causes a lot of collisions, because there could be a lot of the same lengths keys, and the hashing depends on that
        return key.length() % hashtable.length;         // the hashing function is: key's length modulus hashtable's length
    }

    private int findKey(String key) {                   // this function is used to search for a record given the key
        int hashedKey = hashKey(key);                   // this is used to hash the given key
        if (hashtable[hashedKey] != null &&                 // if the hashtable is not empty
                hashtable[hashedKey].key.equals(key)) {     // AND the location of the key in the hashtable equals the given key
            return hashedKey;                               // return the hashed key, that gives the location of the employee in the table
        }

        // The previous part will find the hashed key if no linear probing was made

        // so the next part will work to find the hashed keys if linear probing is applied to them

        int stopIndex = hashedKey;                  // this is the index of the hashed key, it will be saved to be used to stop searching after it

        if (hashedKey == hashtable.length - 1) {    // if you reached the end of the hashtable
            hashedKey = 0;                          // reset the pointer to the front of the hashtable
        } else {
            hashedKey++;                            // else increment the pointer
        }

        while (hashedKey != stopIndex &&                        // while the pointer hasn't reached the stop index
                hashtable[hashedKey] != null &&                 // AND the value in the hashtable is not null (if the value is filled)
                !hashtable[hashedKey].key.equals(key)) {        // AND the hashed key equals the given key
            hashedKey = (hashedKey + 1) % hashtable.length;     // increment the hash key and apply the same hashing algorithm (this is the linear probing step)
        }

        if (hashtable[hashedKey] != null &&                     // if the value in the hash table given the hash key is not null (there is a value in the hashtable at this location)
                hashtable[hashedKey].key.equals(key)) {         // and the hash key equals the given key
            return hashedKey;                                   // return the hashed key because the value is found
        } else {
            return -1;                                          // if it is not found return -1
        }

    }

    private boolean occupied(int index) {       // this function checks if the location to be stored in is already used, returns false if it is empty (null)
        return hashtable[index] != null;
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] == null)
                System.out.println(i + " empty");
            else {
                System.out.println(i + " " + hashtable[i].key + ": " + hashtable[i].employee);

            }
        }
    }
}