public class Account {

    private long money;
    private String accNumber;
    private boolean isBlocked;

    public Account(long money, String accNumber) {
        this.money = money;
        this.accNumber = accNumber;
        this.isBlocked = false;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        if(!isBlocked){
            this.money = money;
        }
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public boolean checkIsBlocked(){
        return isBlocked;
    }

    public void setBlocked(boolean isBlocked){
        this.isBlocked = isBlocked;
    }
}
