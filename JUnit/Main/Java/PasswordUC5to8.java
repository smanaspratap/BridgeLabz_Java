package Java;
import java.util.regex.Pattern;

public class PasswordUC5to8 {
    // Regex explanation for all Password Rules combined[cite: 22, 25, 29, 32]:
    // (?=.*[A-Z])       : Lookahead to ensure at least 1 uppercase letter
    // (?=.*[0-9])       : Lookahead to ensure at least 1 numeric digit
    // (?=[a-zA-Z0-9]*[^a-zA-Z0-9][a-zA-Z0-9]*$) : Lookahead to ensure EXACTLY 1 special character
    // .{8,}             : Ensures the total length is at least 8 characters
    private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[0-9])(?=[a-zA-Z0-9]*[^a-zA-Z0-9][a-zA-Z0-9]*$).{8,}$";

    public boolean validatePassword(String password) {
        if (password == null) return false;
        return Pattern.matches(PASSWORD_PATTERN, password);
    }
}