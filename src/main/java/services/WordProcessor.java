package services;

import java.util.ArrayList;
import java.util.List;

public class WordProcessor {
    private final Dictionary dict;

    public WordProcessor(Dictionary dict) {
        this.dict = dict;
    }

    public List<String> processSubWords(String word) {
        List<String> dictionaryWordList = this.dict.getWordList();
        List<String> processedWords = new ArrayList<>();

        // loop each word from the dictionary
        for (String dictWord : dictionaryWordList) {
            String wordCopy = String.valueOf(word);

            // evaluate each character of the dictionary word
            for (int wordLetterPos = 0; wordLetterPos < dictWord.length(); wordLetterPos++) {
                String dictWordChar = String.valueOf(dictWord.charAt(wordLetterPos));

                if (wordCopy.length() > 0 && wordCopy.contains(dictWordChar))
                    wordCopy = wordCopy.replaceFirst(dictWordChar, "");
                else
                    break;

                if (wordLetterPos == dictWord.length() - 1)
                    processedWords.add(dictWord);
            }
        }

        return processedWords;
    }
}
