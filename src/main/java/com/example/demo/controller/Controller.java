package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Answer;
import com.example.demo.entity.Question;
import com.example.demo.repo.QuestionRepo;

@RestController
public class Controller {
	@Autowired
	QuestionRepo questionRepo;
	
	@PostMapping(value="save")
	public ResponseEntity<Question> saveQandA (@RequestBody Question question){
		Answer answer=new Answer();
		
		for(Answer a:question.getAnswers()) {
			a.setQuestion(question);
			
		}
		question.setAnswers(question.getAnswers());
		questionRepo.save(question);
		return new ResponseEntity<Question>(questionRepo.save(question),HttpStatus.CREATED);
		
	}

}
