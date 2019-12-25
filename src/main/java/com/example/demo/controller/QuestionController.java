package com.example.demo.controller;

import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @PostMapping( "/add-Question" )
    public Question addQuestion( @Valid @RequestBody Question q){
        return questionRepository.save(q);
    }

    @PutMapping( "/update-Question/{id}" )
    public Question updateQuestion( @PathVariable( value="id" ) Long id, @Valid @RequestBody Question q) throws Exception{
        Question old_ques = questionRepository.findById(id).orElseThrow(() -> new Exception("Something Went Worong"));
        old_ques.setQuestionText( q.getQuestionText() );
        old_ques.setCorrectAnswer( q.getCorrectAnswer() );

        old_ques.setGameMode( q.getGameMode() );
        old_ques.setEllenAnswers( q.getEllenAnswers() );
        return questionRepository.save(old_ques);

    }


    @DeleteMapping( "/deleteQuestion/{id}" )
    public ResponseEntity<?> deleteQuestion( @PathVariable( value="id" ) Long id ) throws Exception{
        List<Question> ques_list = questionRepository.findAll();
        for(int i=0;i<ques_list.size();i++){
            Question foundQues = ques_list.get(i);
            if( foundQues.getId() == id )
            {
                questionRepository.delete(foundQues);
                break;
            }

        }
        return ResponseEntity.ok().build();
    }

}
