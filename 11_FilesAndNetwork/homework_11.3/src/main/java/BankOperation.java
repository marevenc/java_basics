public class BankOperation {
    private String accountType;
    private String accountNumber;
    private String currency;
    private String date;
    private String ref;
    private String description;
    private double income;
    private double outgo;

    public BankOperation(String accountType, String accountNumber,
                         String currency, String date, String ref,
                         String description, double income, double outgo) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.date = date;
        this.ref = ref;
        this.description = description;
        this.income = income;
        this.outgo = outgo;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDate() {
        return date;
    }

    public String getRef() {
        return ref;
    }

    public String getDescription() {
        return description;
    }

    public double getIncome() {
        return income;
    }

    public double getOutgo() {
        return outgo;
    }
}
