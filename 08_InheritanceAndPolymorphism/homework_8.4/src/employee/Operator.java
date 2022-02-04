package employee;

import company.Company;

public class Operator extends Employee {
    private final int FIXED_SALARY = 30000;

    public Operator(Company company) {
        super(company);
    }

    @Override
    public int getMonthSalary() {
        return FIXED_SALARY;
    }
}
