import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import services.Dictionary;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TestValidEnglishWords {
    @Test(dataProvider = "validWordsDP")
    public void testValidWords(String word, boolean status) {
        Dictionary dictionary = new Dictionary();

        assertThat(dictionary.isEnglishWord(word), equalTo(status));
    }

    @DataProvider
    public Object[][] validWordsDP() {
        return new Object[][] {
                new Object[] {"alternative", true},
                new Object[] {"development", true},
                new Object[] {"responsibility", true},
        };
    }
}
