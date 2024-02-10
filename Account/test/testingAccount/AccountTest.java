
package testingAccount;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void depositNegativeAmount_balanceRemainsUnchangedTest() {
        Account myAccount = new Account();
        assertEquals(0, myAccount.getBalance());

        myAccount.deposit(-50000);
        assertEquals(0, myAccount.getBalance());

    }
    @Test
    public void depositPositiveAmount_balanceChangesTest(){
        Account myAccount = new Account();
        assertEquals(0, myAccount.getBalance());

        myAccount.deposit(50000);
        assertEquals(50000, myAccount.getBalance());

    }

    @Test
    public void depositPositiveAmountTwice(){
        Account myAccount = new Account();
        assertEquals(0, myAccount.getBalance());

        myAccount.deposit(500);
        assertEquals(500, myAccount.getBalance());
        myAccount.deposit(500);
        assertEquals(1000, myAccount.getBalance());
    }

    @Test
    public void withdrawNegativeAmount_balanceRemainsUnchanged(){
        Account myAccount = new Account();
        assertEquals(0, myAccount.getBalance());

        myAccount.withdraw(-2000);
        assertEquals(0, myAccount.getBalance());
    }
    @Test
    public void withdrawPositiveAmount_changesBalance(){
        Account myAccount = new Account();
        assertEquals(0, myAccount.getBalance());

        myAccount.deposit(1200);
        myAccount.withdraw(1000);
        assertEquals(200, myAccount.getBalance());

    }

    @Test
    public void testWithdrawHigherAmountThanBalance_balanceRemainsUnchanged(){
        Account myAccount = new Account();
        assertEquals(0, myAccount.getBalance());

        myAccount.deposit(200);
        myAccount.withdraw(1000);
        assertEquals(200, myAccount.getBalance());

    }
}