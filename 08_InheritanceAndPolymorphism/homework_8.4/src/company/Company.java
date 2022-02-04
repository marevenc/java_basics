package company;

import employee.Employee;

import java.util.*;

public class Company {
    private List<Employee> employees = new ArrayList<>();
    private int income;

    public Company(int income) {
        this.income = income;
    }

    public void hire(Employee employee){
        employees.add(employee);
    }

    public void hireAll(List<Employee> employeesToHire){
        employees.addAll(employeesToHire);
    }

    public void fire(Employee employee){
        employees.remove(employee);
    }

    public double getIncome(){
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count){
        List<Employee> topSalaryStaff = new ArrayList<>();
        if(count <= 0 || count > employees.size()){
            return topSalaryStaff;
        }

        Collections.sort(employees);
        for(int i = 0; i < count; i++){
            topSalaryStaff.add(employees.get(i));
        }
        return topSalaryStaff;
    }

    public List<Employee> getLowestSalaryStaff(int count){
        List<Employee> lowestSalaryStaff = new ArrayList<>();
        if(count <= 0 || count > employees.size()){
            return lowestSalaryStaff;
        }

        Collections.sort(employees);
        for(int i = 0; i < count; i++){
            lowestSalaryStaff.add(employees.get(employees.size() - 1 - i));
        }
        return lowestSalaryStaff;
    }
}
