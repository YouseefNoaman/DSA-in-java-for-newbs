package com.company;

public class Main {

    public static void main(String[] args) {
        Employee janeJones = new Employee(123,"Jane", "Jones");
        Employee johnDoe = new Employee(456, "John", "Doe");
        Employee marySmith = new Employee(22, "Mary", "Smith" );
        Employee mikeWilson = new Employee(3245, "Mike", "Wilson");
        Employee billEnd = new Employee(78, "Bill", "End" );

        SimpleHashtable ht = new SimpleHashtable();
        ht.put("Jones", janeJones);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Smith", marySmith);

        ht.printHashtable();

        System.out.println("Retrieve key Wilson: " + ht.get("Wilson"));
        System.out.println("Retrieve key Smith: " + ht.get("Smith"));

        ht.remove("Wilson");
        ht.remove("Jones");
        ht.printHashtable();

        System.out.println("Retrieve key Smith: " + ht.get("Smith"));



    }
}
