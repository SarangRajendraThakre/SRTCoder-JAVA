package com.srt.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



//@RestController("/api/") this is wrong 
//@RestController("/api")  this is also wrong 
//🎯 FIX: Use @RequestMapping to define the common base path
@RestController
//@RequestMapping("/api")
//@RequestMapping({"/web","/mobile"})  this will work for both , instead of defining deparatly 
@RequestMapping({"/web","/mobile"}) 
public class QuizController {

//	@PostMapping("/api/createQuiz")
//	public String createQuiz() {
//		return "Quiz got successfully";
//	}
//
//	@GetMapping("/api/getQuiz")
//	public String getQuiz() {
//		return "Quiz got successfully";
//	}
//
//	@PutMapping("/api/updateQuiz")
//	public String updateQuiz() {
//		return "Quiz got successfully";
//	}
//
//	@DeleteMapping("/api/deleteQuiz")
//	public String deleteQuiz() {
//		return "Quiz got successfully";
//	}
	
//	do you notice one thing ahtat api is common in all the api end points 
//	So that you can do  as below by making  @RestController("/api/") 
		

		@PostMapping("/createquiz")
		public String createQuiz() {
			return "Quiz got successfully";
		}

		@GetMapping("/getquiz")
		public String getQuiz() {
			return "Quiz got successfully";
		}

		@PutMapping("/updatequiz")
		public String updateQuiz() {
			return "Quiz got successfully";
		}

		@DeleteMapping("/deletequiz")
		public String deleteQuiz() {
			return "Quiz got successfully";
		}
		
		
		

}
