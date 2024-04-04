public class Clock{
	private int hour;
	private int minute;
	private int seconds;

	public Clock(int hour, int minute, int seconds){
	
	if (hour<=23){
	 this.hour = hour;
	}

	if (minute<=59){
	 this.minute = minute;
	}

	if (seconds<=59){
	 this.seconds = seconds;
	 }
	}

	public void setHour(int numberOfHours){
	if (hour > 23){
	 this.hour = 0;
	if (hour <= 23){
	 this.hour = hour;
	  }
	 }
	}

	public int getHour(){
	 return hour;
	}

	public void setMinute(int numberOfMinute){
	if (minute > 59){
	 this.minute = 0;
	if (minute <= 59){
	  this.minute = minute;
	   }
	  }
	}
	
	public int getMinute(){
	 return minute;
	}

	public void setSeconds(int numberOfSeconds){
	if (seconds > 59){
	 this.seconds = 0;
	if (seconds <= 59){
	  this.seconds = seconds;
	  }
	 }
	}

	public int getSeconds(){
	 return seconds;
	}

	public void displayTime(){	
	System.out.printf("The time is %d : %d : %d", getHour(), getMinute(), getSeconds());
	   }
	 	
	
	





}

	
