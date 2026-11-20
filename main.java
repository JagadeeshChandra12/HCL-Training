import java.util.*;

class Employee {

    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name,
             String department, double salary) {

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

public class main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Ravi", "IT", 50000),
            new Employee(2, "Raj", "HR", 30000),
            new Employee(3, "Kiran", "IT", 70000),
            new Employee(4, "Arjun", "Finance", 45000),
            new Employee(5, "Sai", "HR", 60000)
        );
        /*
        employees.stream()
                 .filter(employee -> employee.department.equals("IT"))
                 .forEach(System.out::println);
         
        employees.stream()
                 .map(employee -> employee.name)
                 .forEach(System.out::println);

        employees.stream()
                 .sorted((e1, e2) -> Double.compare(e1.salary, e2.salary))
                 .forEach(System.out::println);

        employees.stream()
                 .map(employee -> employee.department)
                 .distinct()
                 .forEach(System.out::println);

        employees.stream()
                 .skip(2)
                 .forEach(System.out::println);
        */
       employees.stream()
                .peek(employee->System.out.println("processing of name: "+ employee.name))
                .forEach(System.out::println);

        Optional<Employee> firstEmployee = employees.stream()
                .filter(employee -> employee.department.equals("IT"))
                .findFirst();

        firstEmployee.ifPresent(employee ->
                System.out.println("First IT employee: " + employee));

        // findAny(): finds any matching employee
        Optional<Employee> anyEmployee = employees.parallelStream()
                .filter(employee -> employee.department.equals("HR"))
                .findAny();

        anyEmployee.ifPresent(employee ->
                System.out.println("Any HR employee: " + employee));

        int[] firstArray = {10, 20, 30};
        int[] secondArray = {40, 50, 60};

        int[] combinedArray = java.util.stream.Stream.concat(
                        Arrays.stream(firstArray).boxed(),
                        Arrays.stream(secondArray).boxed())
                .mapToInt(Integer::intValue)
                .toArray();

        OptionalInt firstValueAbove40 = Arrays.stream(combinedArray)
                .filter(number -> number > 40)
                .findFirst();

        firstValueAbove40.ifPresent(number ->
                System.out.println("First value greater than 40: " + number));

        OptionalInt anyEvenNumber = Arrays.stream(combinedArray)
                .filter(number -> number % 2 == 0)
                .findAny();

        anyEvenNumber.ifPresent(number ->
                System.out.println("Any even number: " + number));
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(java.util.stream.Collectors.groupingBy(
                        employee -> employee.department));

        System.out.println("Employees grouped by department:");
        employeesByDepartment.forEach((department, employeeList) -> {
            System.out.println(department + ": " + employeeList);
        });
    }
}