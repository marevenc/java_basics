public abstract class Client {

    private double accountAmount;

    public double getAmount() {
        return accountAmount;
    }

    public void put(double amountToPut) {
        if(amountToPut > 0.0){
            this.accountAmount += amountToPut;
        }
    }

    public void take(double amountToTake) {
        if((amountToTake > 0) && (this.accountAmount >= amountToTake)){
            this.accountAmount -= amountToTake;
        }
    }

}
