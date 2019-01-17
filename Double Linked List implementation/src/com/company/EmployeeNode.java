package com.company;

/*
 *
 *   this class is responsible for the double linked list's node implementation, it has an instance of the Employee class, and another for the EmployeeNode class
 *
 */

public class EmployeeNode {

    // the linked list is composed of a value and a pointer to point at the next value, the value here is the employee object, the address is the employee node object itself
    private Employee employee;      // this is the object of the Employee class to hold the value
    private EmployeeNode next;      // this is used to hold the address of the next node
    private EmployeeNode prev;      // this is used to hold the address of the previous node

    // the constructor takes an Employee as an argument only because we don't know if there will be a next or which node is next
    public EmployeeNode(Employee employee) {
        this.employee = employee;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeNode getNext() {
        return next;
    }

    public void setNext(EmployeeNode next) {
        this.next = next;
    }

    public EmployeeNode getPrev() {
        return prev;
    }

    public void setPrev(EmployeeNode prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return employee.toString();
    }
}
