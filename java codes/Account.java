public class Account{
  private int id;
  private double balance;
  private double annualInterestRate;
  private String date;

  public Account(){
   }
 public void setBalance(double balance){
  if (balance > 0.0){
   this.balance = balance;
   }
  }

  public double getBalance(){
   return balance;
  }

  public void deposit(double depositAmount){
   if (depositAmount > 0.0){
   balance = balance + depositAmount; 
   }
  }

  public void withdraw(double withdrawAmount){
    if (withdrawAmount < balance){
    balance = balance - withdrawAmount;
   }
  }

  public void setAnnualInterestRate(double annualInterestRate){
   this.annualInterestRate = annualInterestRate;
  }

  public double getAnnualInterestRate(){
   return annualInterestRate;
   }

  public double getMonthlyInterestRate(){
   double monthlyInterestRate = (getAnnualInterestRate() / 100) / 12;
   return monthlyInterestRate;
  }

  public double getMonthlyInterest(){
   double monthlyInterestRate = getBalance() * getMonthlyInterestRate();
   return monthlyInterestRate;
  }


  public void setId(int id){
    this.id = id;
   }
 
   public int getId(){
    return id;
   }

   public void setDate(String date){
     this.date = date;
    }

   public String getDate(){
   return date;
    }
  

  






}