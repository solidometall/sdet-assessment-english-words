import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import services.Dictionary;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestEnglishWords {
    @Test(dataProvider = "validWordsDP")
    public void testValidWords(String word, boolean status) {
        Dictionary dictionary = new Dictionary();

        assertThat(dictionary.isEnglishWord(word), is(status));
    }

    @Test(dataProvider = "noValidWordsDP")
    public void testNoValidWords(String word, boolean status) {
        Dictionary dictionary = new Dictionary();

        assertThat(dictionary.isEnglishWord(word), is(status));
    }

    @DataProvider
    public Object[][] validWordsDP() {
        return new Object[][]{
                new Object[]{"alternative", true},
                new Object[]{"development", true},
                new Object[]{"responsibility", true},
        };
    }

    @DataProvider
    public Object[][] noValidWordsDP() {
        return new Object[][]{
                new Object[]{"sudoku", false},
                new Object[]{"teriyaki", false},
                new Object[]{"bitcoin", false},
        };
    }
}
