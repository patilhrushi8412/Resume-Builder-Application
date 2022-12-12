package com.te.resumeBuilder.responce;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResumeResponce {

	private boolean error;
	private String message;
	private Object data;

}
