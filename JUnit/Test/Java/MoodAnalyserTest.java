package Java;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class MoodAnalyserTest {
    /*
    * Tests for the Mood Analyser
    * -testMoodAnalysis(): verifies SAD detection.
    * -testHappyMoods(): Verfies non Sad messages return Happy.
    */
    @Before
    public void initAll(){
        System.out.println("Runs once Before all the tests");
    }
    @Test
    public void testMoodAnalysis(){
        //Writing the Test first
        MoodAnalyser mood = new MoodAnalyser();
        //call the Method
        String Result = mood.analysedMood("This is the sad Message");

        //Assert the test is expecting sad and it will fail if sad is not returned.
        assertEquals("SAD", Result);
    }

    @Test
    public void testHappyMoods() throws Exception{
        // Call the bloody function
        MoodAnalyser M = new MoodAnalyser();
        //Act
        String Result = M.analysedMood("I am in a very Happy mood!!");
        //Assert
        assertEquals("HAPPY", Result);
    }
    @After
    public void afterall(){
        System.out.println("Runs after each test");
    }
}
