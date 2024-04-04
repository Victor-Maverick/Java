public class Car{

	private String model;
	private String year;
	private double price;

	public Car(String model, String year, double price){
	 this.model=model;
	 this.year=year;
	 
	if (price>0.0){
	 this.price=price;
	 } 

	public void setPrice(double priceAmount){
	 if (price>0.0){
	  price=price + priceAmount;
	 }
	}

	public double getPrice(){
	 return price;
	}

	public void setYear(int yearNumber){
	 this.year = year;
	 }
	

	public String getYear(){
	 return year;
	}

	public void setModel(String name){
	 this.model=model;
	}
	
	public String getModel(){
	 return model;
	}


}