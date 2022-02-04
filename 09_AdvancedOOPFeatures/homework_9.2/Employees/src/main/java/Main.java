package main.java;

import java.util.*;

public class Main {

    private static final String STAFF_TXT = "Employees/data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        Calendar calendar = new GregorianCalendar();
        Optional<Employee> optional = staff.stream()
                .filter(employee -> {
                    calendar.setTime(employee.getWorkStart());
                    return calendar.get(Calendar.YEAR) == year;})
                .max(Comparator.comparing(Employee::getSalary));
        return optional.get();

    }
}