import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {

    private ConcurrentHashMap<String, Account> accounts;
    private final Random random = new Random();

    public Bank(ConcurrentHashMap<String, Account> accounts) {
        this.accounts = accounts;
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    private void doTransfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        if(amount > 50000 && isFraud(fromAccountNum, toAccountNum, amount)){
            block(fromAccountNum, toAccountNum);
        } else {
            if(!accounts.get(fromAccountNum).checkIsBlocked() && !accounts.get(toAccountNum).checkIsBlocked()){
                accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
                accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
            }
        }
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        String fromNbr = accounts.get(fromAccountNum).getAccNumber();
        String toNbr = accounts.get(toAccountNum).getAccNumber();

        if (fromNbr.compareTo(toNbr) > 1){
            synchronized (accounts.get(fromAccountNum)){
                synchronized (accounts.get(toAccountNum)){
                    doTransfer(fromAccountNum, toAccountNum, amount);
                }
            }
        } else {
            synchronized (accounts.get(toAccountNum)){
                synchronized (accounts.get(fromAccountNum)){
                    doTransfer(fromAccountNum, toAccountNum, amount);
                }
            }
        }
    }

    public void block(String fromAccountNum, String toAccountNum){
        accounts.get(fromAccountNum).setBlocked(true);
        accounts.get(toAccountNum).setBlocked(true);
    }

    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        Set<String> clients = getClients();
        long sumMoney = 0;
        for (String client : clients){
            sumMoney += getBalance(client);
        }
        return sumMoney;
    }

    public Set<String> getClients(){
        return accounts.keySet();
    }

    public String getRandomClient(){
        int size = getClients().size();
        int item = new Random().nextInt(size);
        int i = 0;
        for(String s : getClients()){
            if(i == item){
                return s;
            }
            i++;
        }
        return null;
    }
}
