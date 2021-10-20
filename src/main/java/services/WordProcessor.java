package services;

import java.util.ArrayList;
import java.util.List;

public class WordProcessor implements IWordProcessor {
    private final Dictionary dict;

    public WordProcessor(Dictionary dict) {
        this.dict = dict;
    }

    @Override
    public List<String> processSubwords(String word) {
        List<String> dictionaryWordList = this.dict.getWordList();
        List<String> processedWords = new ArrayList<>();

        // loop each word in the dictionary
        for (String dictWord : dictionaryWordList) {
            String wordCopy = String.valueOf(word);

            // evaluate each character of the word in the dictionary
            for (int wordLetterPos = 0; wordLetterPos < dictWord.length(); wordLetterPos++) {
                String dictWordChar = String.valueOf(dictWord.charAt(wordLetterPos));

                if (wordCopy.length() > 0 && wordCopy.contains(dictWordChar))
                    wordCopy = wordCopy.replace(dictWordChar,"");
                else
                    break;

                if (wordLetterPos == dictWord.length() - 1)
                    processedWords.add(dictWord);
            }
        }

        return processedWords;
    }
}
