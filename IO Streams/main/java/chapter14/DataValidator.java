package chapter14;

public class DataValidator {

    public static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.length()==11 || isPhoneNumberValidWithAreaCode(phoneNumber);
    }

    private static boolean isPhoneNumberValidWithAreaCode(String phoneNumber) {
        return phoneNumber.startsWith("+234");
    }

    public static boolean isNumberValid(String number) {
        number = number.replaceAll(" ", "");
        String regex = "((234|\\+234)-?|0)?(70|[8-9][0-1])\\d{8}";
        return number.matches(regex);
    }

    public static boolean isEmailValid(String email) {
        email = email.replaceAll(" ", "");
        email = email.toLowerCase();
        String regex = "([a-z]\\.)?[a-z][A-z]+@(enum|semicolon|learnspace|native).africa";
        return email.matches(regex);
    }
}
