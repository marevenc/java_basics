import java.time.LocalDate;

public class DepositAccount extends BankAccount {

    private LocalDate lastIncome;
    private final long TERM = 1;

    public boolean take(double amountToTake) {
        if(LocalDate.now().isAfter(lastIncome.plusMonths(TERM))){
            super.take(amountToTake);
        }
        return false;
    }

    public void put(double amountToPut) {
        super.put(amountToPut);
        lastIncome = LocalDate.now();
    }
}
