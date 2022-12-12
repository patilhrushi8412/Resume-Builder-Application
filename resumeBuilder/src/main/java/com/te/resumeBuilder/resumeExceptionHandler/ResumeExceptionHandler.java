package com.te.resumeBuilder.resumeExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.resumeBuilder.responce.ResumeResponce;
import com.te.resumeBuilder.resumeCustomException.ResumeCustomException;

@RestControllerAdvice
public class ResumeExceptionHandler {

	@ExceptionHandler(ResumeCustomException.class)
	public ResponseEntity<ResumeResponce> exceptionhandler(ResumeCustomException exception) {
		return new ResponseEntity<ResumeResponce>(new ResumeResponce(true, exception.getMessage(), null),
				HttpStatus.BAD_REQUEST);
	}
}
