package Java;
//Mood Analyser to test the moods
public class MoodAnalyser {

    public String analysedMood(String message) {

        if (message.toLowerCase().contains("sad")) {
            return "SAD";
        } else {
            return "HAPPY";
        }
    }
}