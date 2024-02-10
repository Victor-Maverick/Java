import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    @Test
    public void testThatPhoneBookExist(){

        PhoneBook phoneBook = new PhoneBook();
        assertNotNull(phoneBook);

    }

    @Test
    public void testThatPhoneBookCanAddANewContact(){

        PhoneBook phoneBook = new PhoneBook();
        assertEquals("08148624687", phoneBook.addContactToPhoneBook("Msonter", "08148624687") );

    }

    @Test
    public void testThatPhoneBookCanDeleteExistingContact(){

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContactToPhoneBook("Msonter", "08148624687");
        assertNull(phoneBook.deleteContactFromPhoneBook("Msonter"));

    }

    @Test
    public void testThatAContactIsInThePhoneBook(){

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContactToPhoneBook("Msonter", "08148624687");
        assertTrue(phoneBook.checkForContactInPhoneBook("Msonter"));
        assertFalse(phoneBook.checkForContactInPhoneBook("Victor"));

    }

    @Test
    public void checkToDisplayContactsInPhoneBook(){

        PhoneBook phoneBook = new PhoneBook();
        assertNotNull(phoneBook.displayContacts());

    }
}