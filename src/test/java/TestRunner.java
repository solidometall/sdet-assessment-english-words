import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        TestNG objtTng = new TestNG();

        List<String> suites = new ArrayList<String>();

        suites.add("src/TestValidEnglishWords.xml");
        suites.add("src/TestWordsInWord.xml");

        objtTng.setTestSuites(suites);

        objtTng.run();
    }
}