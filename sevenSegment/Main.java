package sevenSegment;

import java.util.Scanner;

public class Main {
    private static final SevenSegment sevenSegment = new SevenSegment();

    public static void main(String[] args) {
        display();
    }
    public static String collectInput(){
        return input("Enter a binary number to print a segment display: ");

    }
    private static void display(){
        try {
            sevenSegment.collectInput(collectInput());
        }
        catch (Exception e){
            print(e.getMessage());
        }
        finally{
            collectInput();
        }

    }

    private static String input(String prompt){
        print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static void print(String menu){
        System.out.println(menu);
    }


}
