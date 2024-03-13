package sevenSegment;

import sevenSegment.Exceptions.BinaryFormatException;
import sevenSegment.Exceptions.InvalidLengthException;

public class SevenSegment {

    private final boolean[] myList = new boolean[8];

    public void collectInput(String binaryNumber){
        validate(binaryNumber);
        print();

    }

    private void validate(String binaryNumber) {
        validateLength(binaryNumber);
        validateBinaryDigits(binaryNumber);
        validateWrongInput(binaryNumber);
        fillCondition(binaryNumber);

    }

    private void print() {
        if(myList[7]) {
            printHorizontal(myList[0]);
            printVertical(myList[1], myList[5]);
            printHorizontal(myList[6]);
            printVertical(myList[2], myList[4]);
            printHorizontal(myList[3]);
        }
    }

    private void fillCondition(String binaryNumber) {
        for(int count = 0; count < myList.length; count++)
            if(binaryNumber.charAt(count) == '1') myList[count] = true;
    }

    public void printVertical(boolean state, boolean second){
        String format = "";
        if(state && second) format ="#          #";
        if(!state && second) format = "#          ";
        if(state && !second) format = "          #";
        for(int count = 0; count < 3; count++) System.out.println(format);
    }

    public void printHorizontal(boolean state){
        if(state)
            for(int count = 0; count < 4; count++) System.out.print(" # ");
        System.out.println();
    }

    private static void validateBinaryDigits(String binaryCode) {
        for(int index = 0; index < binaryCode.length(); index++){
            int one = Integer.parseInt(String.valueOf(binaryCode.charAt(index)));
            boolean condition = one != 1 && one != 0;
            if(condition)throw new BinaryFormatException("non-binary digit in code");
        }
    }

    private static void validateWrongInput(String binaryCode) {
        for(int index = 0; index < binaryCode.length(); index++){
            boolean condition = binaryCode.charAt(index) != '1' && binaryCode.charAt(index) != '0';
            if(condition)throw new NumberFormatException("non digit elements found");
        }
    }

    private static void validateLength(String binaryCode) throws InvalidLengthException {
        if (binaryCode.length() != 8) throw new InvalidLengthException("Length must be eight");
    }



}
