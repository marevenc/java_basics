public class BankAccount {

  private double accountAmount;
  protected final double ACCURACY = 0.001;

  public double getAmount() {
    return accountAmount;
  }

  public void put(double amountToPut) {
    if(amountToPut > 0){
      accountAmount += amountToPut;
    }
  }

  public boolean take(double amountToTake) {
    if(accountAmount - amountToTake > ACCURACY){
      accountAmount -= amountToTake;
      return true;
    }
    return  false;
  }

  public boolean send(BankAccount receiver, double amount){
    if(this.take(amount)){
      receiver.put(amount);
    }
    return false;
  }
}
