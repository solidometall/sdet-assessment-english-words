import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class TestNGRunner {
    public static void main(String[] args) {
        TestNG test = new TestNG();

        List<String> suites = new ArrayList<>();

        suites.add("src/TestEnglishWords.xml");
        suites.add("src/TestWordsInWord.xml");

        test.setTestSuites(suites);

        test.run();
    }
}