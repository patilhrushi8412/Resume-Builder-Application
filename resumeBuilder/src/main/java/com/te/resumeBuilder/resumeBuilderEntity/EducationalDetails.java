package com.te.resumeBuilder.resumeBuilderEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class EducationalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer educationId;
	private String highesteducation;
	private String specialization;
	private String institution;
	private int passOutYear;
	private double percentage;
}
