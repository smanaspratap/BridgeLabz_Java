package Java;
import java.util.regex.Pattern;

public class LastName {
    // Regex: Starts with a capital letter ([A-Z]), followed by 2 or more lowercase letters ([a-z]{2,})
    // This ensures it starts with Cap and has a minimum of 3 characters[cite: 11].
    private static final String LAST_NAME_PATTERN = "^[A-Z][a-z]{2,}$";

    public boolean validateLastName(String lastName) {
        if (lastName == null) return false;
        return Pattern.matches(LAST_NAME_PATTERN, lastName);
    }
}