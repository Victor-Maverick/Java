package logisticServices;
public class LogisticsServices {
    

    public int calculateWageForTheDay(int successfulDelivery) {
        int basePay = 5000;
        int wage = 0;
        if (successfulDelivery < 0 || successfulDelivery > 100) throw new IllegalArgumentException("invalid successful deliveries");

        if(successfulDelivery == 0)return basePay;
        boolean isDeliveryLessThanFiftyPercent = successfulDelivery >= 0 && successfulDelivery < 50;
        boolean isDeliveryBetweenFiftyAndSixtyPercent = successfulDelivery >= 50 && successfulDelivery < 60;
        boolean isDeliveryBetweenSixtyToSixtyNinePercent = successfulDelivery >= 60 && successfulDelivery < 70;
        boolean isDeliveryGreaterThanSixtyNinePercent = successfulDelivery >= 70 && successfulDelivery <= 100;

        if(isDeliveryLessThanFiftyPercent) wage = 160 * successfulDelivery;
        if(isDeliveryBetweenFiftyAndSixtyPercent) wage = 200 * successfulDelivery;
        if(isDeliveryBetweenSixtyToSixtyNinePercent) wage = 250 * successfulDelivery;
        if (isDeliveryGreaterThanSixtyNinePercent) wage = 500 * successfulDelivery;

        return wage + basePay;
    }

}
