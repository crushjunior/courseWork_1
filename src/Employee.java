public class Employee {
    private String fullName;
    private int department;
    private double salary;
    final private int id;
    private static int countId = 1;

    public Employee(String fullName, int department, double salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.id = countId++;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return (int) salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ФИО: " + this.fullName + ". Отдел № " + this.department + ". Зарплата: " + this.salary + " рублей. " +  "ID: " +  id;
    }
}
