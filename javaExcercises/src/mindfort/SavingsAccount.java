package mindfort;

public class SavingsAccount {
    public static double annualInterestRate;
    private double savingsBalance;


    public SavingsAccount(double savingsBalance) {
        if(savingsBalance > 0.0) {
            this.savingsBalance = savingsBalance;
        }
    }

    public void calculateMonthlyInterest(){
        double monthlyInterest = savingsBalance * (0.01 * annualInterestRate) / 12;
        savingsBalance += monthlyInterest;

    }

    public static void modifyInterestRate(){
        annualInterestRate ++;

    }

    public double getSavingsBalance() {
        return savingsBalance;
    }
}
