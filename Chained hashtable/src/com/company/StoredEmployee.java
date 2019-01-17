package com.company;
/*
 *
 *       this class is made to be used to store the key with its Employee object
 *
 */
public class StoredEmployee {

    public String key;
    public Employee employee;

    public StoredEmployee(String key, Employee employee) {
        this.key = key;
        this.employee = employee;
    }
}