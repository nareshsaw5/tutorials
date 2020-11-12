package com.dodo.learning.stream.employee;

public class Employee implements Comparable {

    private int Id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        Id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Employee employee = (Employee) o;

        return Id == employee.Id;
    }

    @Override public int hashCode() {
        return Id;
    }

    @Override public String toString() {
        return "Employee{" + "Id=" + Id + ", name='" + name + '\'' + ", salary=" + salary + '}';
    }

    @Override public int compareTo(Object o) {
        Employee other = (Employee) o;
        return this.getId() < other.getId() ? -1 : this.getId() == other.getId() ? 0 : 1;
    }
}
