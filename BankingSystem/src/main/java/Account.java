public class Account {
    private String name;
    private String accountNo;
    private AccountType accountType;
    private double balance;
    private static int accountCount = 1;

    public Account(String name, AccountType accountType, double balance) {
        this.name = name;
//        String appendedNo = String.format()
        accountNo = "HBL" + String.format("%04d", accountCount++);
        this.accountType = accountType;
        this.balance = balance;
    }

    public Account(String name, AccountType accountType) {
        this(name, accountType, 0.00);
    }

    public Account(String name) {
        this(name, AccountType.CURRENT_ACCOUNT);
    }

    public Account() {
        this("dumy", AccountType.CURRENT_ACCOUNT);
    }


    public String getName() {
        return name;
    }

    public static int getAccountCount() {
        return accountCount;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = AccountType.valueOf(accountType);
    }


    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean depositMoney(double balance) {
        if (balance > 0) {
            this.balance += balance;
            return true;
        } else {
            System.out.println("Invalid Amount to deposit");
            return false;
        }
    }

    public boolean withdrawMoney(double amount) {
        if (amount <= this.balance && amount > 0) {
            this.balance -= amount;
            return true;
        } else {
            System.out.println("Amount specified is not correct!");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Title: %-15s Account No: %s Account Type: %-20s Balance: $ %10.2f".formatted(name, accountNo, accountType.toString(), balance);
//        return "Title: " + name + " Account No: " + accountNo
//                + " Account Type: " + accountType + " Balance: $ " + balance;
    }
}
