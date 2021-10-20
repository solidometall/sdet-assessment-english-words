import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import services.Dictionary;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestNoValidEnglishWords {
    @Test(dataProvider = "noValidWordsDP")
    public void testValidWords(String word, boolean status) {
        Dictionary dictionary = new Dictionary();

        assertThat(dictionary.isEnglishWord(word), is(status));
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
