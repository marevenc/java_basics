import junit.framework.TestCase;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MoneyInBankTest extends TestCase{
    Bank bank;
    @Override
    protected void setUp(){
        ConcurrentHashMap<String, Account> accounts = new ConcurrentHashMap<>();
        accounts.put("1", new Account(100000, "1"));
        accounts.put("2", new Account(200000, "2"));
        accounts.put("3", new Account(300000, "3"));
        bank = new Bank(accounts);
    }

    public void testGetSumAllAccounts(){
        long expected = 600000;
        long actual = bank.getSumAllAccounts();
        assertEquals(expected, actual);
        System.out.println(expected + " " + actual);
    }
}
