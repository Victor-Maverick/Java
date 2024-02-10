public class HeartRates{
	private String firstName;
	private String lastName;
	private int dobMonth;
	private int dobDay;
	private int dobYear;
	
	public HeartRates(){
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
	  return dobDay;hju[p-0-0
	}

	public void setDobYear(int dobYear){
	  this.dobYear = dobYear;
	}

	public int getDobYear(){
	  return dobYear;
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

	




}