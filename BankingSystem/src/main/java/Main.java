import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static final String fileName = "bank.csv";


    public static void main(String[] args) {

        Bank bank = new Bank(100);

//        addDummyAccounts(bank);
        loadData(bank, fileName);

        int choice;
        do {
            mainMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Account Title: ");
                    String accountTitle = scanner.nextLine();
                    AccountType accountType = Bank.getAccountTypeWithInput();
                    System.out.print("Enter opening Balance: ");
                    double balance = Double.parseDouble(scanner.nextLine());
                    String accountNo = bank.addAccount(accountTitle, accountType, balance);
                    System.out.println("Account created successfully...\n Your Account Details:");
                    bank.listAccountDetails(accountNo);
                }
                case 2 -> {
                    System.out.print("Enter your account No: ");
                    String accountNo = scanner.nextLine();
                    bank.updateAccount(accountNo);
                }
                case 3 -> {
                    System.out.print("Enter your account No: ");
                    String accountNo = scanner.nextLine();
                    if (bank.deleteAccount(accountNo)) {
                        System.out.println("Your account deleted Successfully!");
                    } else {
                        System.out.println("Account Number does not found!!!");
                    }
                }
                case 4 -> {
                    System.out.print("Enter your account No: ");
                    String accountNo = scanner.nextLine();
                    bank.listAccountDetails(accountNo);
                }
                case 5 -> {
                    System.out.print("Enter your account No: ");
                    String accountNo = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    bank.withdrawAmount(accountNo, amount);
                    System.out.println("Amount withdrawal Successfully...");
                }
                case 6 -> {
                    System.out.print("Enter your account No: ");
                    String accountNo = scanner.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    bank.depositAmount(accountNo, amount);
                    System.out.println("Amount deposited Successfully...");
                }
                case 7 -> {
                    bank.listAllAccountsDetails();
                }
                case 0 -> {
                    break;
                }
                default -> {
                    System.out.print("Invalid choice");
                }
            }
        } while (choice != 0);

        saveData(bank, fileName);

    }

    public static void mainMenu() {
        System.out.print("""
                
                1. Add Account
                2. Update Account
                3. Delete Account
                4. List a single Account
                5. With Draw money
                6. Deposit money
                7. List All Accounts
                0. Exit
                Enter your choice: """);
    }

    private static void saveData(Bank bank, String fileName) {

        ICsvBeanWriter beanWriter = null;

        //        accountNo, title, accountType, balance
        try
        {
            beanWriter = new CsvBeanWriter(new FileWriter(fileName), CsvPreference.STANDARD_PREFERENCE);
            final String[] header = new String[] { "accountNo", "name", "accountType", "balance"};

            final CellProcessor[] processors = getProcessors();

            // write the header
            beanWriter.writeHeader(header);

            // write the beans data
            for (var b : bank.accounts) {
                beanWriter.write(b, header, processors);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            try {
                assert beanWriter != null;
                beanWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void loadData(Bank bank, String fileName) {

        try(ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(fileName), CsvPreference.STANDARD_PREFERENCE))
        {
            // the header elements are used to map the values to the bean
            final String[] headers = beanReader.getHeader(true);

//            final String[] headers = new String[] { "accountNo", "name", "accountType", "balance"};
            final CellProcessor[] processors = getProcessors();

            Account account;
            while ((account = beanReader.read(Account.class, headers, processors)) != null) {
                bank.accounts.add(account);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addDummyAccounts(Bank bank) {

        var allAccounts = AccountType.values();

        bank.addAccount("Daud Ahmad", allAccounts[0], 100);
        bank.addAccount("Sajid Tariq", allAccounts[1], 50);
        bank.addAccount("Abdullah", allAccounts[0], 1000);
        bank.addAccount("Ali Asad", allAccounts[2], 0);
        bank.addAccount("Usman Ali", allAccounts[1], 10_000);
        bank.addAccount("Wasif Dar", allAccounts[0], 0);
        bank.addAccount("Wasif Dar", allAccounts[0], 0);
        bank.addAccount("Wasif Dar", allAccounts[0], 0);
        bank.addAccount("Wasif Dar", allAccounts[0], 0);
        bank.addAccount("Wasif Dar", allAccounts[0], 0);
        bank.addAccount("Wasif Dar", allAccounts[0], 0);
        bank.addAccount("Wasif Dar", allAccounts[0], 0);
        bank.addAccount("Wasif Dar", allAccounts[0], 0);
        bank.addAccount("Wasif Dar", allAccounts[0], 0);
        bank.addAccount("Salman Yousuf", allAccounts[0], 500);
    }

    private static CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[]{
                new NotNull(), // accountNo
                new NotNull(), // title
                new NotNull(), // accountType
                new NotNull(new ParseDouble()) // balance
        };
        return processors;
    }

}
