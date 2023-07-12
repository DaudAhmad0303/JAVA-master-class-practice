public class Account {

//    Class implementation in Inheritance.java
    private String accountNumber;
    private long balance = 0;
    private String name;
    private String email;
    private String phoneNumber;

    public Account() {
        this("12345", 9999, "Alen", "alen@email.com", "(92) 303-12345");
        System.out.println("No-Args Constructor Called.");
    }

    public Account(String accountNumber, long balance, String name, String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        System.out.println("Parameterized constructor is called.");
    }

    public Account(String name, String email, String phoneNumber) {
        this("12345", 0, name, email, phoneNumber);
    }

    public void depositFund(long amount){
        System.out.println("Amount added: " + amount + ", Account balance: " + balance);
        this.balance += amount;
    }

    public void withdrawFund(long amount){
        if (amount > balance) {
            System.out.println("Account balance is low! Cannot withdraw funds.");
        }else {
            this.balance -= amount;
            System.out.println("Amount withdrawal: " + amount + ", Remaining Balance: " + balance);
        }
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

//    public void setBalance(long balance) {
//        this.balance = balance;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
