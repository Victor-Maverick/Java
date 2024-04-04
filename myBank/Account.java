package myBank;

public class Account {
    private String name;
    private int balance = 0;
    private String pin;
    private int number;

    public Account(String name, int number, String pin){
        this.pin = pin;
        this.name = name;
        this.number = number;
    }
    public int checkBalance(String pin) {
        validatePin(pin);
        return balance;
    }


    public void deposit(int depositAmount) {
        validateAmount(depositAmount);
        balance += depositAmount;
    }

    private void validateAmount(int depositAmount) {
        if(depositAmount <= 0)throw new InvalidAmountException("amount should be greater than 0");
    }

    public void withdraw(int withdrawAmount, String atmPin) {
        validateWithdrawAmount(withdrawAmount);
        validateAmountLimit(withdrawAmount);
        validatePin( atmPin);
        balance -= withdrawAmount;
    }

    public int getAccountNumber(){
        return this.number;
    }
    private void validateAmountLimit(int withdrawAmount) {
        if(withdrawAmount > balance) throw new InsufficientFundsException("Insufficient funds");
    }

    private static void validateWithdrawAmount(int withdrawAmount) {
        if (withdrawAmount <= 0) throw new InvalidAmountException("withdraw amount should be greater than 0");

    }

    private void validatePin(String pin) {
        if(!this.pin.equals(pin))throw new InvalidPinException("Wrong pin");
    }


}
