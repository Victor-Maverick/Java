package chapter14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataValidatorTest {
    @Test
    public void validatePhoneNumber2(){
        String phoneNumber = "09023453222";
        boolean isPhoneNumberValid = DataValidator.isNumberValid(phoneNumber);
        assertTrue(isPhoneNumberValid);
    }

    @Test
    public void validatePhoneNumber(){
        String phoneNumber = "";
        boolean isPhoneNumberValid = DataValidator.isNumberValid(phoneNumber);
        assertFalse(isPhoneNumberValid);
    }

    @Test
    public void validatePhoneNumber3(){
        String phoneNumber = "+2349023453222";
        boolean isPhoneNumberValid = DataValidator.isNumberValid(phoneNumber);
        assertTrue(isPhoneNumberValid);
    }
    @Test
    public void validatePhoneNumber4(){
        String phoneNumber = "+2347123453222";
        boolean isPhoneNumberValid = DataValidator.isNumberValid(phoneNumber);
        assertFalse(isPhoneNumberValid);
    }
    @Test
    public void validatePhoneNumber5(){
        String phoneNumber = "8023453222";
        boolean isPhoneNumberValid = DataValidator.isNumberValid(phoneNumber);
        assertTrue(isPhoneNumberValid);
    }

    @Test
    public void validatePhoneNumber6(){
        String phoneNumber = "802 3453 222 ";
        boolean isPhoneNumberValid = DataValidator.isNumberValid(phoneNumber);
        assertTrue(isPhoneNumberValid);
    }
    @Test
    public void validateEmail(){
        String email = "victor@semicolon.africa";
        boolean isEmailValid = DataValidator.isEmailValid(email);
        assertTrue(isEmailValid);
    }

    @Test
    public void validateEmail2(){
        String email = "VICTOR@semicolon.africa";
        boolean isEmailValid = DataValidator.isEmailValid(email);
        assertTrue(isEmailValid);
    }

}