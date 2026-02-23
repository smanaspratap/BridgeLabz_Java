package Java;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class EmailParameterizedTest {

    Email emailValidator = new Email();

    // Parameterized test to validate multiple email address entries [cite: 44, 45]
    // The @ValueSource provides a list of sample emails to clear[cite: 34].
    @ParameterizedTest
    @ValueSource(strings = {
            "abc@yahoo.com",
            "abc-100@yahoo.com",
            "abc.100@yahoo.com",
            "abc111@abc.com",
            "abc-100@abc.net",
            "abc.100@abc.com.au",
            "abc@1.com",
            "abc@gmail.com.com",
            "abc+100@gmail.com"
    })
    public void givenMultipleValidEmails_ShouldReturnTrue(String email) {
        assertTrue(emailValidator.validateEmail(email));
    }
}