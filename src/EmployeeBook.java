public class EmployeeBook {
    private final Employee[] employees;
    private int size;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public void addEmployee(String fullName, int department, double salary) {
        if (size >= employees.length) {
            System.out.println("Employees book is full. Adding a new contact is restricted.");
        }
        Employee newEmployee = new Employee(fullName, department, salary);
        employees[size++] = newEmployee;
    }

    public void printAllEmployees() {
        System.out.println("Список сотрудников: ");
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            System.out.println(employee.toString());
        }
    }

    public double getMonthExpenses() {
        int monthExpenses = 0;
        for (Employee element : employees) {
            if (element != null) {
                monthExpenses += element.getSalary();
            }
        }
        return monthExpenses;
    }

    public String findPoorEmployee() {
        double minSalary = 999999;
        Employee employeeWithMinSalary = employees[0];
        for (Employee employee : employees) {
            if (employee != null) {
                if (minSalary > employee.getSalary()) {
                    minSalary = employee.getSalary();
                    employeeWithMinSalary = employee;
                }
            }
        }
        return employeeWithMinSalary.getFullName();
    }

    public String findRichEmployee() {
        double maxSalary = 1;
        Employee employeeWithMaxSalary = employees[0];
        for (Employee employee : employees) {
            if (employee != null) {
                if (maxSalary < employee.getSalary()) {
                    maxSalary = employee.getSalary();
                    employeeWithMaxSalary = employee;
                }
            }
        }
        return employeeWithMaxSalary.getFullName();
    }

    public double getMiddleSalary() {
        return getMonthExpenses() / employees.length;
    }

    public void printNamesEmployees() {
        System.out.println("ФИО сотрудников: ");
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            System.out.println(employee.getFullName());
        }
    }
}
