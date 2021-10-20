package services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Dictionary implements IDictionary {
    private final List<String> wordList;

    public Dictionary() {
        this.wordList = loadEnglishWords();
    }

    @Override
    public List<String> getWordList() {
        return this.wordList;
    }

    @Override
    public boolean isEnglishWord(String word) {
        return this.wordList.contains(word);
    }

    private List<String> loadEnglishWords() {
        String file_path = "src/main/java/resources/english_word_list.txt";
        List<String> word_list = new ArrayList<>();

        try {
            word_list = Files.readAllLines(Paths.get(file_path), StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return word_list;
    }
}
