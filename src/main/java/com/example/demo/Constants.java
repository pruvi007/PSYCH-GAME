package com.example.demo;

import com.example.demo.model.GameMode;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final int MAX_ANSWER_LEN = 1000;
    public static final int MAX_QUESTION_LEN = 100;
    public static final int MAX_NO_OF_QUESTIONS = 100;
    public  static Map<String, GameMode> QA_files = new HashMap<>();

    static{

        QA_files.put("qa_facts.txt", GameMode.IS_THIS_A_FACT);
        QA_files.put("qa_unscramble.txt", GameMode.UNSCRAMBLE);
        QA_files.put("qa_words.txt", GameMode.WORD_UP);
    }

}
