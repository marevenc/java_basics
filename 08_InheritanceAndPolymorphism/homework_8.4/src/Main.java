import company.Company;
import employee.Employee;
import employee.Manager;
import employee.Operator;
import employee.TopManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company company = new Company(12_000_000);

        for(int i = 0; i < 180; i++){
            company.hire(new Operator(company));
        }

        for(int i = 0; i < 80; i++){
            company.hire(new Manager(company));
        }

        for(int i = 0; i < 10; i++){
            company.hire(new TopManager(company));
        }

        System.out.println("Самые высокие зарплаты:");
        for(Employee employee : company.getTopSalaryStaff(15)){
            System.out.println(employee);
        }

        System.out.println("Самые низкие зарплаты:");
        for(Employee employee : company.getLowestSalaryStaff(30)){
            System.out.println(employee);
        }
    }
}
