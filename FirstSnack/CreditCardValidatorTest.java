import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CreditCardValidatorTest{

	@Test
	public void testForTheCardType(){

	CreditCardValidator validator = new CreditCardValidator();
	validator.setCardType("4234568739473");
	assertEquals("Visa", validator.getCardType()); 

	}

	@Test
	public void testForTheLengthOfDigit(){
	CreditCardValidator validator = new CreditCardValidator();
	validator.setDigitLength("4234568739473");	
	assertEquals(13, validator.getDigitLength());
	}


	@Test
	public void testForValidity(){
        CreditCardValidator validator = new CreditCardValidator();
	validator.setValidityStatus("234319283049582");
	assertEquals("Invalid Card", validator.getValidityStatus());

	}



}