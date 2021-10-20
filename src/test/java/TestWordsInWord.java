import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import services.WordProcessor;
import services.Dictionary;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestWordsInWord {
    @Test(dataProvider = "wordsInWordDP")
    public void testValidWords(String word, int quantity) {
        Dictionary dictionary = new Dictionary();
        WordProcessor processor = new WordProcessor(dictionary);

        List<String> wordList = processor.processSubwords(word);
        assertThat(wordList, hasSize(equalTo(quantity)));
    }

    @DataProvider
    public Object[][] wordsInWordDP() {
        return new Object[][] {
                new Object[] {"alternative", 44},
                new Object[] {"art", 2},
                new Object[] {"available", 9},
                new Object[] {"working", 21},
        };
    }
}
