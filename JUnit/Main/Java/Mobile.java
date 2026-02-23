package Java;
import java.util.regex.Pattern;

public class Mobile {
    // Regex: 2 digits for country code (^[0-9]{2}), a space (\\s), and exactly 10 digits ([0-9]{10}$)
    private static final String MOBILE_PATTERN = "^[0-9]{2}\\s[0-9]{10}$";

    public boolean validateMobile(String mobile) {
        if (mobile == null) return false;
        return Pattern.matches(MOBILE_PATTERN, mobile);
    }
}