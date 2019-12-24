package com.example.demo.controller;

import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dev")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/questions")
    public List<Question> questions(){
        return questionRepository.findAll();
    }

    @GetMapping("/questions/{mode}")
    public List<Question> questionsByMode(@PathVariable( value="mode" ) String mode){
        List<Question> q = questionRepository.findAll();
        List<Question> modeQues = new ArrayList<Question>();
        for(int i=0;i<q.size();i++)
        {
            String foundMode = q.get(i).getGameMode().toString();
            if( mode.equals(foundMode) )
                modeQues.add(q.get(i));

        }
        return modeQues;

    }

}
