import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;
    private static int count;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    @BeforeEach
    public void setup() {
        account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @Test
    public void deposit() {
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
    }

    @Test
    public void withdraw_branch() {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    @Test
    public void withdraw_notbranch() {
//        double balance = account.withdraw(600.00, false);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(600.00, false));
//        assertEquals(400.00, balance, 0);
    }

    @Test
    public void getBalance_deposit() {
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @Test
    public void getBalance_withdraw() {
        double balance = account.withdraw(200.00, true);
        assertEquals(800.00, balance, 0);
    }

    @Test
    public void isChecking_true() {
        assertTrue(account.isChecking(), "The account is NOT a Checking Account");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("This executes after any test cases. Count = " + count++);
    }

    @AfterEach
    public void teardown() {
        System.out.println("Count = " + count++);
    }
}