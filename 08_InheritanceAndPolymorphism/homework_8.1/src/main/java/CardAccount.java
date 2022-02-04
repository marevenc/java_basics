public class CardAccount extends BankAccount {

    private final double COMMISSION = 1.01;

    public boolean take(double amountToTake){
        super.take(amountToTake * COMMISSION);
        return false;
    }

}
