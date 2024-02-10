public class AutoPolicyTest{

  public static void main(String[] args){

    AutoPolicy policy1 = new AutoPolicy(23224321, "Ford Mustang", "MP");
    AutoPolicy policy2 = new AutoPolicy(4224321, "Rolls Cullinan", "NY");

    System.out.printf("Account #: %d; Car: %s; %s%n", policy1.getAccountNumber(), policy1.getMakeAndModel(), policy1.getState());
    System.out.printf("Account #: %d; Car: %s; %s%n", policy2.getAccountNumber(), policy2.getMakeAndModel(), policy2.getState());
  }
    /*public static void policyInNorthEastState(AutoPolicy policy){
      System.out.println("The auto policy:");
      System.out.printf("Account #: %d; Car: %s;%nState %s %s a North East state%n%n", policy.getAccountNumber(), policy.getMakeAndModel(), policy.getState(), (policy.isNorthEastState()? "is":"is not"));
    }*/


}