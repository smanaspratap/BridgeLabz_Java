package Java;

// 1. Updated imports to JUnit 5 (Jupiter)
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    // Instantiate the validation classes
    FirstName firstNameValidator = new FirstName();
    LastName lastNameValidator = new LastName();
    Email emailValidator = new Email();
    Mobile mobileValidator = new Mobile();
    PasswordUC5to8 passwordValidator = new PasswordUC5to8();

    // 2. Updated annotation
    @BeforeEach
    public void setUp() {
        System.out.println("Runs Before each of the tests.");
    }

   // --- HAPPY TEST CASES: Validate successful entries [cite: 40] ---

    @Test
    public void givenValidFirstName_ShouldReturnTrue() {
        assertTrue(firstNameValidator.validatename("Manas"));
    }

    @Test
    public void givenValidLastName_ShouldReturnTrue() {
        assertTrue(lastNameValidator.validateLastName("Doe"));
    }

    @Test
    public void givenValidEmail_ShouldReturnTrue() {
        assertTrue(emailValidator.validateEmail("abc.xyz@bl.co.in"));
    }

    @Test
    public void givenValidMobile_ShouldReturnTrue() {
        assertTrue(mobileValidator.validateMobile("91 9919819801"));
    }

    @Test
    public void givenValidPassword_ShouldReturnTrue() {
        assertTrue(passwordValidator.validatePassword("Passw0rd!"));
    }


    @Test
    public void givenInvalidFirstName_ShouldReturnFalse() {
        assertFalse(firstNameValidator.validatename("jo")); // Starts with lowercase, too short
    }

    @Test
    public void givenInvalidLastName_ShouldReturnFalse() {
        assertFalse(lastNameValidator.validateLastName("D")); // Too short
    }

    @Test
    public void givenInvalidEmail_ShouldReturnFalse() {
        assertFalse(emailValidator.validateEmail("abc.xyz@.com")); // Missing domain name before extension
    }

    @Test
    public void givenInvalidMobile_ShouldReturnFalse() {
        assertFalse(mobileValidator.validateMobile("919919819801")); // Missing space
    }

    @Test
    public void givenInvalidPassword_ShouldReturnFalse() {
        assertFalse(passwordValidator.validatePassword("password")); // No uppercase, no number, no special char
    }

    // 3. Updated annotation and print statement
    @AfterEach
    public void tearDown() {
        System.out.println("Runs After each of the tests.");
    }
}