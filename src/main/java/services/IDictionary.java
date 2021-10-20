package services;

import java.util.List;

public interface IDictionary {
    List<String> getWordList();

    boolean isEnglishWord(String word);
}
