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
            if (employee == null) {
                System.out.println("Свободная ячейка");
            } else {
                System.out.println(employee.toString());
            }
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
        double minSalary = Double.MAX_VALUE;
        Employee employeeWithMinSalary = null;
        for (Employee employee : employees) {
            if (employee != null) {
                if (minSalary > employee.getSalary()) {
                    minSalary = employee.getSalary();
                    employeeWithMinSalary = employee;
                }
            }
        }
        if (employeeWithMinSalary != null) {
            return employeeWithMinSalary.getFullName();
        } else {
            return null;
        }

    }

    public String findRichEmployee() {
        double maxSalary = Double.MIN_VALUE;
        Employee employeeWithMaxSalary = null;
        for (Employee employee : employees) {
            if (employee != null) {
                if (maxSalary < employee.getSalary()) {
                    maxSalary = employee.getSalary();
                    employeeWithMaxSalary = employee;
                }
            }
        }
        if (employeeWithMaxSalary != null) {
            return employeeWithMaxSalary.getFullName();
        } else {
            return null;
        }

    }

    public double getMiddleSalary() {
        int current = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                current ++;
            }
        }
        if (current != 0) {
            return getMonthExpenses() / current;
        } else {
            return 1;
        }
    }

    public void printNamesEmployees() {
        System.out.println("ФИО сотрудников: ");
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            System.out.println(employee.getFullName());
        }
    }

    public void increaseSalary(double percent) {
        double newSalary;
        for (Employee employee : employees) {
            if (employee != null) {
                newSalary = employee.getSalary() * percent/100 + employee.getSalary();
                employee.setSalary(newSalary);
            }
        }
    }

    public void findPoorEmployeeOfDepartment(int department) {
      int minSalary = 999999;
        Employee employeeWithMinSalary = employees[0];
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                if (employee.getSalary() < minSalary) {
                    minSalary = employee.getSalary();
                    employeeWithMinSalary = employee;
                }
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой отдела № " + department + ": " + employeeWithMinSalary.getFullName());
    }

    public void findRichEmployeeOfDepartment(int department) {
        int maxSalary = 1;
        Employee employeeWithMaxSalary = employees[0];
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                if (employee.getSalary() > maxSalary) {
                    maxSalary = employee.getSalary();
                    employeeWithMaxSalary = employee;
                }
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой отдела № " + department + ": " + employeeWithMaxSalary.getFullName());
    }

    public void monthExpensesOfDepartment(int department) {
        int salaryOfDepartment = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                salaryOfDepartment += employee.getSalary();
            }
        }
        System.out.println("Сумма затрат на зарплату по отделу № " + department + ": " + salaryOfDepartment);
    }

    public void middleSalaryOfDepartment(int department) {
        int current = 0;
        double sumSalary = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                sumSalary += employee.getSalary();
                current ++;
            }
        }
        System.out.println("Средняя зарплата по отделу № " + department + ": " + sumSalary/current);
    }

    public void increaseSalaryOfDepartment(int department, double percent) {
        double newSalary;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                newSalary = employee.getSalary() * percent/100 + employee.getSalary();
                employee.setSalary(newSalary);
            }
        }
    }

    public void printEmployeesOfDepartment(int department) {
        System.out.println("Список сотрудников отдела № " + department + ":");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("ФИО: " + employee.getFullName() + "." + " Зарплата: " + employee.getSalary() + "." + " ID: " + employee.getId());
            }
        }
    }

    public void employeesSalaryLessThen(int number) {
        System.out.println("Список сотрудников, зарплата которых меньше, чем " + number + ":");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < number) {
                System.out.println("ID: " + employee.getId() + ". " + "ФИО: " + employee.getFullName() + ". " + "Зарплата: " + employee.getSalary());
            }
        }
    }

    public void employeesSalaryMoreThen(int number) {
        System.out.println("Список сотрудников, зарплата которых больше, чем " + number + ":");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= number) {
                System.out.println("ID: " + employee.getId() + ". " + "ФИО: " + employee.getFullName() + ". " + "Зарплата: " + employee.getSalary());
            }
        }
    }

    public boolean deleteEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                return true;
            }
        }
        return false;
    }

    public void changeEmployeeSalary(String fullName, double newSalary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getFullName().contains(fullName)) {
                employee.setSalary(newSalary);
            }
        }
    }

    public void changeEmployeeDepartment(String fullName, int newDepartment) {
        for (Employee employee : employees) {
            if (employee != null && employee.getFullName().contains(fullName)) {
                employee.setDepartment(newDepartment);
            }
        }
    }

    public void printEmployeesByDepartments() {
        System.out.println("Сотрудники отдела № 1:");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == 1) {
                System.out.println(employee.getFullName());
            }
        }
        System.out.println("Сотрудники отдела № 2:");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == 2) {
                System.out.println(employee.getFullName());
            }
        }
        System.out.println("Сотрудники отдела № 3:");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == 3) {
                System.out.println(employee.getFullName());
            }
        }
        System.out.println("Сотрудники отдела № 4:");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == 4) {
                System.out.println(employee.getFullName());
            }
        }
        System.out.println("Сотрудники отдела № 5:");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == 5) {
                System.out.println(employee.getFullName());
            }
        }
    }
}
