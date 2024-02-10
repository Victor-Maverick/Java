package mindfort;

public class SavingsAccount1 {

    public static void main(String[] args){
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        SavingsAccount.annualInterestRate = 4;

        for (int count = 1; count <= 12; count++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.printf("Month %2d: %10.2f     %10.2f%n", count, saver1.getSavingsBalance(), saver2.getSavingsBalance());

        }

        SavingsAccount.modifyInterestRate();
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.printf("First Account interest %6.2f     Second Account Interest%10.2f%n", saver1.getSavingsBalance(), saver2.getSavingsBalance());

    }

}
