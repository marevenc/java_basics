import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static Bank bank;
    public static final int NUMBER_OF_CLIENTS = 10;

    public static void main(String[] args) {
        bank = new Bank(addClientsAccounts());
        long sumBefore = bank.getSumAllAccounts();
        System.out.println("В банке до начала транзакций - " + sumBefore);
        addClients();
        System.out.println("В банке после завершения всех транзакций - " + bank.getSumAllAccounts());
    }

    protected static ConcurrentHashMap<String, Account> addClientsAccounts() {
        ConcurrentHashMap<String, Account> accounts = new ConcurrentHashMap<>();
        for(int i = 0; i < NUMBER_OF_CLIENTS; i++){
            accounts.put(String.valueOf(Integer.valueOf(i)), new Account(ThreadLocalRandom.current().nextLong(1000000), String.valueOf(Integer.valueOf(i))));
        }
        return accounts;
    }

    protected static void addClients(){
        ArrayList<Thread> clients = new ArrayList<>();
        for(int i = 0; i < NUMBER_OF_CLIENTS; i++){
            clients.add(new Thread(Main::clientsBehavior));
        }
        clients.forEach(Thread::start);
        clients.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private static synchronized void clientsBehavior(){
        String firstClient = bank.getRandomClient();
        String secondClient = bank.getRandomClient();
        while(secondClient.equals(firstClient)){
            secondClient = bank.getRandomClient();
        }

        try {
            bank.transfer(firstClient, secondClient, (long) (bank.getBalance(firstClient) * new Random().nextDouble()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
