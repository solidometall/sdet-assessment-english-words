import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import services.Dictionary;
import services.WordProcessor;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class TestSingleWordInWord {
    @Test(dataProvider = "singleWordsInWordDP")
    public void testSingleWord(String word, int quantity) {
        Dictionary dictionary = new Dictionary();
        WordProcessor processor = new WordProcessor(dictionary);

        List<String> wordList = processor.processSubwords(word);
        assertThat(wordList, hasSize(equalTo(quantity)));
    }

    @DataProvider
    public Object[][] singleWordsInWordDP() {
        return new Object[][] {
                new Object[] {"at", 1},
                new Object[] {"do", 1},
                new Object[] {"tv", 1},
                new Object[] {"or", 1},
        };
    }
}