package com.te.resumeBuilder.resumeBuilderEntity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.te.resumeBuilder.converter.ListToStringConverter;

import lombok.Data;


@Data
@Entity
public class ResumeBuilder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String employeeId;
	private String resumeId;
	private String firstName;
	private String lastName;
	private String highestEducation;
	private String technology;
	private String totalExperience;
	private String releventExperience;
	@Convert(converter = ListToStringConverter.class)
	private List<String> summary;

	@OneToOne(cascade = CascadeType.ALL)
	private TechnicalSkills technicalSkills;

	@OneToOne(cascade = CascadeType.ALL)
	private EducationalDetails educationalDetails;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private List<ProjectDetails> projectDetails;

}
