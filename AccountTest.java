import myBank.Account;
import myBank.InsufficientFundsException;
import myBank.InvalidAmountException;
import myBank.InvalidPinException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {
    private Account account;

    @BeforeEach
    public void startEachWth(){
        account = new Account("name", 0, "correctPin");
    }

    @Test
    public void depositPositiveAmount_balanceEqualsAmountDepositedTest(){
        assertEquals(0, account.checkBalance("correctPin"));
        account.deposit(3000);
        assertEquals(3000, account.checkBalance("correctPin"));
    }

    @Test
    public void depositNegativeAmount_throwInvalidAmountException(){
        assertThrows(InvalidAmountException.class, ()-> account.deposit(-1000));
        assertEquals(0, account.checkBalance("correctPin"));
    }

    @Test
    public void depositPositiveAmountTwice_balanceIncreasesTwiceTest(){
        assertEquals(0, account.checkBalance("correctPin"));
        account.deposit(3000);
        assertEquals(3000, account.checkBalance("correctPin"));
        account.deposit(3000);
        assertEquals(6000, account.checkBalance("correctPin"));
    }

    @Test
    public void depositAmount_withdraw_balanceDecreasesTest(){
        assertEquals(0, account.checkBalance("correctPin"));
        account.deposit(3000);
        assertEquals(3000, account.checkBalance("correctPin"));
        account.withdraw(2000, "correctPin");
        assertEquals(1000, account.checkBalance("correctPin"));
    }

    @Test
    public void depositAmount_withdrawNegativeAmount_throwsExceptionTest(){

        account.deposit(3000);
        assertEquals(3000, account.checkBalance("correctPin"));
        assertThrows(InvalidAmountException.class, ()-> account.withdraw(-2000, "correctPin"));
        assertEquals(3000, account.checkBalance("correctPin"));
    }

    @Test
    public void depositAmount_withdrawZero_throwsExceptionTest(){

        account.deposit(3000);
        assertEquals(3000, account.checkBalance("correctPin"));
        assertThrows(InvalidAmountException.class, ()-> account.withdraw(0, "correctPin"));
        assertEquals(3000, account.checkBalance("correctPin"));
    }

    @Test
    public void depositAmount_withdrawAboveBalance_throwsException(){

        account.deposit(3000);
        assertEquals(3000, account.checkBalance("correctPin"));
        assertThrows(InsufficientFundsException.class, ()-> account.withdraw(4000, "correctPin"));
    }

    @Test
    public void withdrawZero_throwsExceptionTest(){
        assertEquals(0, account.checkBalance("correctPin"));
        assertThrows(InvalidAmountException.class, ()-> account.withdraw(0, "correctPin"));

    }

    @Test
    public void deposit_withdrawTwice_balanceDecreasesTwiceTest(){

        account.deposit(3000);
        assertEquals(3000, account.checkBalance("correctPin"));
        account.withdraw(1000, "correctPin");
        assertEquals(2000, account.checkBalance("correctPin"));
        account.withdraw(1500, "correctPin");
        assertEquals(500, account.checkBalance("correctPin"));
    }

    @Test
    public void deposit_withdrawWithWrongPin_throwsExceptionTest(){

        account.deposit(3000);
        assertEquals(3000, account.checkBalance("correctPin"));
        assertThrows(InvalidPinException.class, ()-> account.withdraw(2000, "incorrectPin"));
        assertEquals(3000, account.checkBalance("correctPin"));
    }

    @Test
    public void checkBalanceWithWrongPin_throwsExceptionTest(){
        assertThrows(InvalidPinException.class, ()-> account.checkBalance("incorrectPin"));
    }

}
