package employee;

import company.Company;

public class TopManager extends Employee{
    private final int FIXED_SALARY = 100000;
    private final double FIXED_BONUS = 2.5;

    public TopManager(Company company) {
        super(company);
    }

    @Override
    public int getMonthSalary() {
        if(company.getIncome() > 10_000_000){
            return (int) (FIXED_SALARY * FIXED_BONUS);
        }
        return FIXED_SALARY;
    }
}
