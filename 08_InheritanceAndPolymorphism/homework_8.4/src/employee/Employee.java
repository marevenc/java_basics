package employee;

import company.Company;

public abstract class Employee implements IEmployee, Comparable<Employee> {

    Company company;

    public Employee(Company company){
        this.company = company;
    }

    @Override
    public int compareTo(Employee employee) {
        if(this.getMonthSalary() < employee.getMonthSalary()){
            return 1;
        }
        if(this.getMonthSalary() > employee.getMonthSalary()){
            return -1;
        } else
        return 0;
    }

    public String toString(){
        return this.getMonthSalary() + " руб.";
    }
}
