package com.company;

import java.util.Objects;

public class Employee {

    // the employee will hold 3 values as shown
    private int id;
    private String fName;
    private String lName;

    // this is a constructor, it is used to initialize an object of the class given these parameters
    public Employee() {     // this constructor basically does nothing
    }

    // this is an overloaded constructor, it is the same but with different parameters if it would be initialized in a different way
    public Employee(int id, String fName, String lName) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
    }

    // to use the private variables of this class outside of it, you need to create setter and getter functions to save and retrieve values from the variables
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }


    // if you try to print out the employees, it will print only the address of the object, not the contents, so you need to override the original function to print out the contents of the object
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }

    // this function checks if the object equals another object or not, by comparing the values in the object like id, fName,lName
    // this function is overridden because there is an available function but it compares the address of the objects, not the contents
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return getId() == ((Employee) o).getId() &&
                getfName().equals(((Employee) o).getfName()) &&
                getlName().equals(((Employee) o).getlName());

    }
}
