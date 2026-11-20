import java.util.*;
public class employee {
    int id;
    String name;
    String department;
    double salary;

    employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Name: " + name +
               ", Department: " + department +
               ", Salary: " + salary;
    }
}