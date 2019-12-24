package com.example.demo.controller;

import com.example.demo.Constants;
import com.example.demo.Pair;
import com.example.demo.Utils;
import com.example.demo.model.GameMode;
import com.example.demo.model.Player;
import com.example.demo.model.Question;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Map;

@RestController
@RequestMapping("/dev")
public class PopulateQA {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping( "/add-questions-from-file" )
    public void addQuestionsFromFile() throws Exception{
        questionRepository.deleteAll();

        for(Map.Entry<String,GameMode> entry : Constants.QA_files.entrySet()){
            int quesNo = 0;
            String fileName = entry.getKey();
            @NotNull GameMode gameMode = entry.getValue();
            for( Pair<String,String> q_a : Utils.readQAFile(fileName) ){
                Question q = new Question();
                q.setQuestionText(q_a.getFirst());
                q.setCorrectAnswer(q_a.getSecond());
                q.setGameMode(gameMode);
                questionRepository.save(q);
                quesNo+=1;
                if( quesNo > Constants.MAX_NO_OF_QUESTIONS )
                    break;
            }

        }
    }

    @GetMapping( "/add-dummy-users" )
    public void addDummyUsers() throws Exception{
        playerRepository.deleteAll();
        Player luffy = new Player();
        luffy.setName("Monkey D. Luffy");
        luffy.setPicUrl("https://i.imgur.com/PrCEBd7.png");
        luffy.setPsychFaceUrl("https://i.imgur.com/SPzynwl.png");

        Player robin = new Player();
        robin.setName("Nico Robin");
        robin.setPicUrl("https://i.imgur.com/kB7StJm.png");
        robin.setPsychFaceUrl("https://i.imgur.com/tnJTeaG.png");

        playerRepository.save(luffy);
        playerRepository.save(robin);
    }


}
