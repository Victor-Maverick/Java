import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest{

	@Test
	public void setName(){
	Account account = new Account();
	account.setName("Susannah");
	assertEquals("Susannah", account.getName());

	}


}