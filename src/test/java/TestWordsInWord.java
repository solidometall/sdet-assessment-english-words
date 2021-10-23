import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import services.Dictionary;
import services.WordProcessor;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class TestWordsInWord {
    @Test(dataProvider = "wordsInWordDP")
    public void testValidWords(String word, int quantity) {
        Dictionary dictionary = new Dictionary();
        WordProcessor processor = new WordProcessor(dictionary);

        List<String> wordList = processor.processSubWords(word);
        assertThat(wordList, hasSize(equalTo(quantity)));
    }

    @Test(dataProvider = "singleWordsInWordDP")
    public void testSingleWord(String word, int quantity) {
        Dictionary dictionary = new Dictionary();
        WordProcessor processor = new WordProcessor(dictionary);

        List<String> wordList = processor.processSubWords(word);
        assertThat(wordList, hasSize(equalTo(quantity)));
    }

    @Test(dataProvider = "emptyWordInWordDP")
    public void testEmptyWord(String word, int quantity) {
        Dictionary dictionary = new Dictionary();
        WordProcessor processor = new WordProcessor(dictionary);

        List<String> wordList = processor.processSubWords(word);
        assertThat(wordList, hasSize(equalTo(quantity)));
    }

    @DataProvider
    public Object[][] wordsInWordDP() {
        return new Object[][]{
                new Object[]{"alternative", 66},
                new Object[]{"art", 2},
                new Object[]{"available", 14},
                new Object[]{"working", 20},
        };
    }

    @DataProvider
    public Object[][] singleWordsInWordDP() {
        return new Object[][]{
                new Object[]{"at", 1},
                new Object[]{"do", 1},
                new Object[]{"tv", 1},
                new Object[]{"or", 1},
        };
    }

    @DataProvider
    public Object[][] emptyWordInWordDP() {
        return new Object[][]{
                new Object[]{"", 0},
                new Object[]{"  ", 0},
        };
    }
}
