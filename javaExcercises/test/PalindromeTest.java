import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeTest{

    @Test
    public void testThatNumberIsAPalindrome(){

        Palindrome palindrome = new Palindrome();
        boolean result = palindrome.checkPalindrome("12321");
        assertTrue(result);


    }

}