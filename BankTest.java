import myBank.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTest {

    private Bank bank;


    @BeforeEach
    public void setBank(){
        bank = new Bank("Chase");
    }

    @Test
    public void accountIsCreated_returnsAccountTest(){
        Account customer1 = bank.registerCustomer("firstName", "lastName", "correctPin");
        Account customer2 = bank.registerCustomer("firstName", "last Name", "Pin");
        Account customer3 = bank.registerCustomer("Name", "last Name", "Pin code");
        assertEquals(customer2, bank.findAccount(2));
        assertEquals(customer1, bank.findAccount(1));

    }

    @Test
    public void createAccount_deposit_balanceChangesTest(){
        Account customer1 = bank.registerCustomer("first name", "last name", "correctPin");
        bank.deposit(1, 200);
        assertEquals(200, bank.checkBalance(1, "correctPin"));

    }

    @Test
    public void createAccount_depositTwice_balanceIncreasesTwiceTest(){
        Account customer1 = bank.registerCustomer("first name", "last name", "correctPin");
        bank.deposit(1, 200);
        assertEquals(200, bank.checkBalance(1, "correctPin"));
        bank.deposit(1, 200);
        assertEquals(400, bank.checkBalance(1, "correctPin"));

    }

    @Test
    public void createThreeAccounts_depositLastCreated_balanceOfOthersIsUnchangedTest(){
        Account customer1 = bank.registerCustomer("Msonter", "Victor", "1212");
        Account customer2 = bank.registerCustomer("Grey", "Hound", "1212");
        Account customer3 = bank.registerCustomer("Femi", "Victor", "1912");

        bank.deposit(3, 200);
        assertEquals(200, bank.checkBalance(3, "1912"));
        assertEquals(0, bank.checkBalance(1, "1212"));
        assertEquals(0, bank.checkBalance(2, "1212"));
    }

    @Test
    public void createAccount_deposit_withdrawPositiveAmount_balanceDecreasesTest(){
        Account customer1 = bank.registerCustomer("first name", "last name", "correctPin");
        bank.deposit(1, 200);
        assertEquals(200, bank.checkBalance(1, "correctPin"));
        bank.withdraw(1, 100, "correctPin");
        assertEquals(100, bank.checkBalance(1, "correctPin"));
    }

    @Test
    public void createAccount_deposit_withdrawNegativeAmount_throwsExceptionTest(){
        Account customer1 = bank.registerCustomer("first name", "last name", "correctPin");
        bank.deposit(1, 200);
        assertEquals(200, bank.checkBalance(1, "correctPin"));
        assertThrows(IllegalArgumentException.class, ()->bank.withdraw(1, -100, "correctPin"));
        assertEquals(200, bank.checkBalance(1, "correctPin"));
    }

    @Test
    public void createAccount_deposit_withdrawWithWrongPin_throwsExceptionTest(){
        Account customer1 = bank.registerCustomer("firstName", "lastName", "correctPin");
        bank.deposit(1, 200);
        assertEquals(200, bank.checkBalance(1, "correctPin"));
        assertThrows(InvalidPinException.class, ()->bank.withdraw(1, 100, "incorrectPin"));
        assertEquals(200, bank.checkBalance(1, "correctPin"));
    }

    @Test
    public void createAccount_deposit_withdrawMoreThanBalance_throwsExceptionTest(){
        Account customer1 = bank.registerCustomer("firstName", "lastName", "correctPin");
        bank.deposit(1, 200);
        assertEquals(200, bank.checkBalance(1, "correctPin"));
        assertThrows(InsufficientFundsException.class, ()->bank.withdraw(1, 400, "1212"));
        assertEquals(200, bank.checkBalance(1, "correctPin"));
    }

    @Test
    public void createAccount_deposit_withdrawTwice_balanceDecreasesTwiceTest(){
        Account customer1 = bank.registerCustomer("firstName", "lastName", "correctPin");
        bank.deposit(1, 2000);
        assertEquals(2000, bank.checkBalance(1, "correctPin"));
        bank.withdraw(1, 700, "correctPin");
        assertEquals(1300, bank.checkBalance(1, "correctPin"));
        bank.withdraw(1, 900, "correctPin");
        assertEquals(400, bank.checkBalance(1, "correctPin"));
    }

    @Test
    public void registerCustomer_deposit_transfer_balance_decreasesTest(){
        Account customer1 = bank.registerCustomer("Msonter", "Victor", "1212");
        Account customer2 = bank.registerCustomer("Femi", "Victor", "1912");
        bank.deposit(1, 2000);
        assertEquals(2000, bank.checkBalance(1,"1212"));
        bank.transfer(1, 2, 800, "1212");
        assertEquals(1200, bank.checkBalance(1, "1212"));
        assertEquals(800, bank.checkBalance(2, "1912"));
    }

    @Test
    public void registerCustomers_deposit_transferNegativeAmount_throwsExceptionTest(){
        Account customer1 = bank.registerCustomer("Msonter", "Victor", "correctPin");
        Account customer2 = bank.registerCustomer("Grey", "Hound", "correctPin");
        Account customer3 = bank.registerCustomer("Femi", "Victor", "correctPin");
        bank.deposit(1, 2000);
        assertEquals(2000, bank.checkBalance(1, "correctPin"));
        assertThrows(InvalidAmountException.class, ()-> bank.transfer(1, 3, -800, "correctPin"));
        assertEquals(2000, bank.checkBalance(1, "correctPin"));
        assertEquals(0, bank.checkBalance(3, "correctPin"));
    }

    @Test
    public void registerCustomers_deposit_transferWithWrongPin_throwsExceptionTest(){
        Account customer1 = bank.registerCustomer("Msonter", "Victor", "correctPin");
        Account customer2 = bank.registerCustomer("Grey", "Hound", "correctPin");
        Account customer3 = bank.registerCustomer("Femi", "Victor", "correctPin");
        bank.deposit(1, 2000);
        assertEquals(2000, bank.checkBalance(1, "correctPin"));
        assertThrows(InvalidPinException.class, ()-> bank.transfer(1, 3, 800, "incorrectPin"));
        assertEquals(2000, bank.checkBalance(1, "correctPin"));
        assertEquals(0, bank.checkBalance(3, "correctPin"));
    }

    @Test
    public void registerCustomers_deposit_transferAmountGreaterThanBalance_throwsExceptionTest(){
        Account customer1 = bank.registerCustomer("Msonter", "Victor", "correctPin");
        Account customer2 = bank.registerCustomer("Grey", "Hound", "correctPin");
        Account customer3 = bank.registerCustomer("Femi", "Victor", "correctPin");
        bank.deposit(1, 2000);
        assertEquals(2000, bank.checkBalance(1, "correctPin"));
        assertThrows(InsufficientFundsException.class, ()-> bank.transfer(1, 3, 8000, "correctPin"));
        assertEquals(2000, bank.checkBalance(1, "correctPin"));
        assertEquals(0, bank.checkBalance(3,"correctPin"));
    }

    @Test
    public void registerCustomers_deposit_transferToSelf_balanceRemainsUnchangedTest(){
        Account customer1 = bank.registerCustomer("Msonter", "Victor", "correctPin");
        Account customer2 = bank.registerCustomer("Grey", "Hound", "correctPin");
        Account customer3 = bank.registerCustomer("Femi", "Victor", "correctPin");
        bank.deposit(1, 2000);
        assertEquals(2000, bank.checkBalance(1, "correctPin"));
        bank.transfer(1, 1, 2000, "correctPin");
        assertEquals(2000, bank.checkBalance(1, "correctPin"));
    }

    @Test
    public void registerAccounts_transferToInvalidAccount_throwsExceptionTest(){
        Account customer1 = bank.registerCustomer("firstName", "secondName", "correctPin");
        Account customer2 = bank.registerCustomer("firstName", "lastName", "correctPin");
        bank.deposit(1, 5000);
        assertThrows(InvalidAccountException.class, ()->bank.transfer(1, 3, 400, "correctPin"));
        assertEquals(5000, bank.checkBalance(1, "correctPin"));
    }
    @Test
    public void registerCustomers_removeSecondAccountLastCustomerNumberIsUnchangedTest_() {
        Account customer1 = bank.registerCustomer("Msonter", "Victor", "1212");
        Account customer2 = bank.registerCustomer("Grey", "Hound", "1212");
        Account customer3 = bank.registerCustomer("Femi", "Victor", "1912");

        bank.removeAccount(2, "1212");
        assertEquals(customer3, bank.findAccount(3));

    }

    @Test
    public void removeAccountFromEmptyList_throwsExceptionTest_() {
        assertThrows(InvalidAccountException.class, ()-> bank.removeAccount(2, "1212"));
    }

}
