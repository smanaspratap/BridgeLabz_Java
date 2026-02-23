package Java;
import java.util.regex.Pattern;

public class FirstName{
    // Regex: Starts with a capital letter ([A-Z]), followed by 2 or more lowercase
    // letters ([a-z]{2,})
    // This ensures it starts with Cap and has a minimum of 3 characters[cite: 8].

    private static final String FirstNamePattern = "^[A-Z][a-z]{2,}$";
    public boolean validatename(String firstName){
        if(firstName == null){
            return false;
        }
        return Pattern.matches(FirstNamePattern, firstName);
    }
}
