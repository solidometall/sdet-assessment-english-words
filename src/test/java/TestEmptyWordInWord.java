import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import services.Dictionary;
import services.WordProcessor;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class TestEmptyWordInWord {
    @Test(dataProvider = "emptyWordInWordDP")
    public void testEmptyWord(String word, int quantity) {
        Dictionary dictionary = new Dictionary();
        WordProcessor processor = new WordProcessor(dictionary);

        List<String> wordList = processor.processSubwords(word);
        assertThat(wordList, hasSize(equalTo(quantity)));
    }

    @DataProvider
    public Object[][] emptyWordInWordDP() {
        return new Object[][] {
                new Object[] {"", 0},
                new Object[] {"  ", 0},
        };
    }
}
