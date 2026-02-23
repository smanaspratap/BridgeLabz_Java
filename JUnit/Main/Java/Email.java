package Java;
import java.util.regex.Pattern;

public class Email {
    // Regex explanation for Email (abc.xyz@bl.co.in format)[cite: 14, 15]:
    // ^[a-zA-Z0-9]+          : Starts with alphanumeric characters (mandatory 'abc')
    // ([._+-][a-zA-Z0-9]+)* : Optional special characters followed by alphanumeric (optional 'xyz')
    // @[a-zA-Z0-9]+          : Mandatory '@' symbol followed by alphanumeric (mandatory 'bl')
    // \\.[a-zA-Z]{2,4}       : Mandatory '.' followed by 2 to 4 letters (mandatory 'co')
    // (\\.[a-zA-Z]{2,4})?$   : Optional '.' followed by 2 to 4 letters at the end (optional 'in')
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}(\\.[a-zA-Z]{2,4})?$";

    public boolean validateEmail(String email) {
        if (email == null) return false;
        return Pattern.matches(EMAIL_PATTERN, email);
    }
}