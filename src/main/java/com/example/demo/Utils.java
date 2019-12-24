package com.example.demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List< Pair<String,String> > readQAFile(String fileName) throws FileNotFoundException {
        String question,answer;
        List< Pair<String,String> > q_a = new ArrayList< Pair<String,String> >();

        try{
            BufferedReader br = new BufferedReader( new FileReader(fileName));
            do{
                question = br.readLine();
                answer = br.readLine();
                if( question==null || answer==null || question.length()>Constants.MAX_QUESTION_LEN -1|| answer.length()>Constants.MAX_ANSWER_LEN )
                    continue;
                q_a.add( new Pair<String,String>(question,answer) );
            }while( question!=null && answer!=null );

        }catch(Exception ignored){

        }
        return q_a;
    }
}
