package employee;

import company.Company;

import java.util.Random;

public class Manager extends Employee{
    private final int FIXED_SALARY = 50000;
    private final double FIXED_BONUS = 0.05;
    int bonus;

    public Manager(Company company) {
        super(company);
        bonus = getBonus();
    }

    @Override
    public int getMonthSalary() {
        return FIXED_SALARY + bonus;
    }

    public int getBonus(){
        int min = 115_000;
        int max = 140_000;
        int diff = max - min;
        Random random = new Random();
        return (int) ((random.nextInt(diff +1) + min) * FIXED_BONUS);
    }

}
