public class CarApplication{

public static void main(String... args){

Car car1 = new Car("LexusES350", "2022", 2300000.00);
Car car2 = new Car("McClaren", "2023", 4200000.00);

System.out.printf("Model: %s, year: %s, price: $%.0f%n", car1.getModel(), car1.getYear(), car1.getPrice());

System.out.printf("Model: %s, year: %s, price: $%.0f%n%n", car2.getModel(), car2.getYear(), car2.getPrice());

double discountedPriceForCar1 = 2300000 - (0.05) * 2300000;

double discountedPriceForCar2 = 4200000 - (0.07) * 4200000;

System.out.printf("Model: %s, year: %s, discounted price: $%.0f%n", car1.getModel(), car1.getYear(), discountedPriceForCar1);

System.out.printf("Model: %s, year: %s, discounted price: $%.0f%n", car2.getModel(), car2.getYear(), discountedPriceForCar2);


}






}