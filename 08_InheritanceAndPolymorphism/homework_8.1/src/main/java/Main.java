public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        BankAccount cardAccount = new CardAccount();
        BankAccount depositAccount = new DepositAccount();

        bankAccount.put(50000);
        System.out.println("На банковском счету " + bankAccount.getAmount() + " рублей");
        cardAccount.put(25000);
        System.out.println("На карте " + cardAccount.getAmount() + " рублей");
        depositAccount.put(200000);
        System.out.println("На депозите " + depositAccount.getAmount() + " рублей");

        bankAccount.take(5000);
        System.out.println("На банковском счету " + bankAccount.getAmount() + " рублей");

        if (!cardAccount.take(30000)) {
            System.out.println("На счету недостаточно средств");
        }
        System.out.println("На карте " + cardAccount.getAmount() + " рублей");

        cardAccount.send(bankAccount, 5000);
        System.out.println("На банковском счету " + bankAccount.getAmount() + " рублей");
        System.out.println("На карте " + cardAccount.getAmount() + " рублей");

        if(!depositAccount.send(bankAccount, 5000)){
            System.out.println("Вы не можете снимать деньги в течение месяца с момента прошлого пополнения");
        }
        System.out.println("На банковском счету " + bankAccount.getAmount() + " рублей");
        System.out.println("На депозите " + depositAccount.getAmount() + " рублей");
    }
}
