public class Main {
    public static void main(String[] args) {

       EmployeeBook employeeBook =  new EmployeeBook();

        employeeBook.addEmployee("Козлова Наталья Геннадьевна", 1, 41000);
        employeeBook.addEmployee("Иванов Иван Иванович", 2, 56000);
        employeeBook.addEmployee("Петров Петр Петрович", 3, 22000);
        employeeBook.addEmployee("Сидорова Зинаида Павловна", 4, 141000);
        employeeBook.addEmployee("Скурихин Игорь Валентинович", 5, 37000);
        employeeBook.addEmployee("Пуц Светлана Васильевна", 1, 55000);
        employeeBook.addEmployee("Вагин Алексей Сергеевич", 2, 78000);
        employeeBook.addEmployee("Кошкин Егор Егорович", 3, 41330);
        employeeBook.addEmployee("Жириновский Владимир Владимирович", 4, 20999);
        employeeBook.addEmployee("Маркс Карл Карлович", 5, 45699);

        System.out.println("Список сотрудников:");
        employeeBook.printAllEmployees();

        System.out.println();

        System.out.println("Сумма затрат на зарплаты в месяц: " + employeeBook.getMonthExpenses());

        System.out.println();
        System.out.println("Сотрудник с минимальной зарплатой: " + employeeBook.findPoorEmployee());

        System.out.println();
        System.out.println("Сотрудник с максимальной зарплатой: " + employeeBook.findRichEmployee());

        System.out.println();
        System.out.println("Средняя зарплата: " + employeeBook.getMiddleSalary());

        System.out.println();
        System.out.println("ФИО сотрудников: " + employeeBook.printNamesEmployees()); /* Почему ИДЕА здесь подчеркивает ошибку и просит сделать возвращающий метод??*/
    }
}









