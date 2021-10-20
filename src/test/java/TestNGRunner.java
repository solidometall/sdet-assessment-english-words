import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class TestNGRunner {
    public static void main(String[] args) {
        TestNG objtTNG = new TestNG();

        List<String> suites = new ArrayList<>();

        suites.add("src/TestValidEnglishWords.xml");
        suites.add("src/TestWordsInWord.xml");

        objtTNG.setTestSuites(suites);

        objtTNG.run();
    }
}