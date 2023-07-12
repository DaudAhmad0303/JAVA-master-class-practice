import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    static Scanner scanner = new Scanner(System.in);

    final String bankName = "Habib Bank Limited";

    List<Account> accounts;

    public String getBankName() {
        return bankName;
    }

    public Bank(int noOfAccounts) {
        accounts = new ArrayList<>(noOfAccounts);
    }

    public String addAccount(String name, AccountType accountType, double openingBalance) {
        Account newAccount = new Account(name, accountType, openingBalance);
        accounts.add(newAccount);
        return newAccount.getAccountNo();
    }

    public String addAccount(String name, AccountType accountType) {
        return addAccount(name, accountType, 0.0);
    }

    public boolean deleteAccount(String accountNo) {

        for (Account account : accounts) {
            if (account.getAccountNo().equalsIgnoreCase(accountNo)) {
                accounts.remove(account);
                return true;
            }
        }
        return false;
    }

    public void updateAccount(String accountNo) {

        for (Account account : accounts) {
            if (account.getAccountNo().equalsIgnoreCase(accountNo)) {
                int choice;
                System.out.print("""
                        What do you want to update in your account:
                        1. Update Name
                        2. Update Account Type
                        Enter your choice: """);
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter updated Name: ");
                        account.setName(scanner.nextLine());
                    }
                    case 2 -> {
                        account.setAccountType(getAccountTypeWithInput());
                    }
                    default -> {
                        System.out.println("Invalid Choice!!!");
                        return;
                    }
                }
                System.out.println("Account updated successfully");
                return;
            }
        }
        System.out.println("Account Number does not found!!!");
    }

    public void depositAmount(String accountNo, double amount) {
        for (Account account : accounts) {
            if (account.getAccountNo().equalsIgnoreCase(accountNo)) {
                account.depositMoney(amount);
                return;
            }
        }
    }

    public void withdrawAmount(String accountNo, double amount) {
        for (Account account : accounts) {
            if (account.getAccountNo().equalsIgnoreCase(accountNo)) {
                account.withdrawMoney(amount);
                return;
            }
        }
    }

    public static AccountType getAccountTypeWithInput() {
        System.out.print("""
                        Choose the account type from below:
                        1. Current Account
                        2. Saving Account
                        3. Checking Account
                        Enter your choice: """);
        int choice = scanner.nextInt();
        scanner.nextLine();
        AccountType accountType = null;
        var allAccountTypes = AccountType.values();
        if (choice >= 1 && choice <= 3) {
            accountType = allAccountTypes[choice - 1];
        } else {
            System.out.println("Invalid Choice!!!");
        }
        return accountType;
    }

    public void listAccountDetails(String accountNo) {

        for (Account account : accounts) {
            if (account.getAccountNo().equalsIgnoreCase(accountNo)) {
                System.out.println(account);
                return;
            }
        }
        System.out.println("Account Number does not found!!!");
    }

    public void listAllAccountsDetails() {
        System.out.println("All Accounts in " + bankName + " are listed below: ");
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

}

