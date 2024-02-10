public class HealthProfile{
   private String firstName;
   private String lastName;
   private String gender;
   private int dobYear;
   private int dobMonth;
   private int dobDay;
   private double height;
   private double weight;

   public HealthProfile(){
   }

   public void setFirstName(String firstName){
    this.firstName = firstName;
   }

   public String getFirstName(){
    return firstName;
   }

   public void setLastName(String lastName){
    this.lastName = lastName;
   }

   public String getLastName(){
    return lastName;
   }

   public void setGender(String gender){
    this.gender = gender;
   }

   public String getGender(){
    return gender;
   }

   public void setDobYear(int dobYear){
     this.dobYear = dobYear;
   }

   public int getDobYear(){
    return dobYear;
   }

   public void setDobMonth(int dobMonth){
     this.dobMonth = dobMonth;
   }

   public int getDobMonth(){
    return dobMonth;
   }

    public void setDobDay(int dobDay){
     this.dobDay = dobDay;
   }

   public int getDobDay(){
    return dobDay;
   }

   public int getAge(){
    int ageInYears = 2023 - getDobYear();
    return ageInYears;
    }

   public int getMaxHeartRate(){
    int maxHeartRate = 220 - getAge();
    return maxHeartRate;
   }

   public double getLowerTargetRange(){
    double lowerTargetRange = 0.5 * getMaxHeartRate();
    return lowerTargetRange;
   }

   public double getUpperTargetRange(){
    double upperTargetRange = 0.85 * getMaxHeartRate();
    return upperTargetRange;
   }

   public void setHeight(double height){
    this.height = height;
   }

   public double getHeight(){
    return height;
   }

    public void setWeight(double weight){
    this.weight = weight;
   }

   public double getWeight(){
    return weight;
   }

   public double getBodyMassIndex(){
   double bodyMassIndex = weight / (height * height);
   return bodyMassIndex;
   
   }

   




}