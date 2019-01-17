package com.company;

import java.util.LinkedList;
import java.util.ListIterator;
/*
*
*       this is another implementation for the hashtable, to solve the collision problem, the last time linear probing was used, this time a technique that is called chaining
*       chaining simply is about using a linked list to store objects, this has a benefit of storing as many objects as needed, also storing multiple objects at the same location
*       if they have the same hashedKey, this is useful because a linked list can expand in runtime, and save as many objects as needed, but this is bad if the memory is not available
*       as the linked list uses a lot of memory to store objects
*
*/
public class ChainedHashtable {

    private LinkedList<StoredEmployee>[] hashtable;     // this is a new LinkedList of type StoredEmployee

    public ChainedHashtable() {                         // the constructor is used to initialize the hashtable with 10 locations to store values
        hashtable = new LinkedList[10];
        for (int i = 0; i < hashtable.length; i++)      // this for loop is used to initialize the locations in the hashtable
            hashtable[i] = new LinkedList<StoredEmployee>();        // if this is removed it will make an error: java.lang.NullPointerException, it needs to be initialized
    }

    public void put(String key, Employee employee) {                        // this function is used to add the employee to the hashtable given the key
        int hashedKey = hashKey(key);                                       // first the key is hashed through the hashKey function
        hashtable[hashedKey].add(new StoredEmployee(key, employee));        // then the key and the employee are stored through a new StoredEmployee object in the location given by the hashedKey
    }

    public Employee get(String key) {                                       // this function retrieves an Employee given the key
        int hashedKey = hashKey((key));                                     // first the key is hashed
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();        // then the hashtable is put into a listIterator
        StoredEmployee employee = null;                                                     // an empty object to store the retrieved value
        while (iterator.hasNext()) {                                                        // while the iterator did not reach the end of the hashtable
            employee = iterator.next();                                                     // the employee will equal the object that the iterator is currently at
            if (employee.key.equals(key))                                                   // if the employee's key equals the given key to search for
                return employee.employee;                                                   // return that employee
        }
        return null;                                                                        // else return null, means that the employee is not in the hashtable
    }

    public Employee remove(String key) {             // this function removes an Employee given its key  (simply it is like the get function, just remove the object if it is found)
        int hashedKey = hashKey((key));
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;
        int index = -1;
        while (iterator.hasNext()) {
            employee = iterator.next();
            index++;
            if (employee.key.equals(key))
                break;
        }
        // the last part is just like the above get() function
        // the next part will remove the object
        if (employee == null)                                       // if the employee is not found, return null
            return null;
        else {
            hashtable[hashedKey].remove(index);                     // if it is found remove it from the hashtable
            return employee.employee;                               // then return the found employee
        }
    }


    private int hashKey(String key) {           // this hashing function is bad, it causes a lot of collisions, because there could be a lot of the same lengths keys, and the hashing depends on that
        return key.length() % hashtable.length;         // the hashing function is: key's length modulus hashtable's length
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {            // this for loop is used to print out the hashtable
            if (hashtable[i].isEmpty())                         // if the location in the hashtable is null, it will print out empty
                System.out.println(i + ": empty");
            else {
                System.out.print(i + ": ");                     // else it will print out the contents
                ListIterator<StoredEmployee> iterator = hashtable[i].listIterator();            // an iterator to print out the hashtable
                while (iterator.hasNext()) {                                // while it has not reached the end
                    System.out.print(iterator.next().employee);             // print out the employee(s) in that specific location
                    System.out.print("-> ");
                }
                System.out.println("null");
            }
        }
        System.out.println("END");
    }

}
