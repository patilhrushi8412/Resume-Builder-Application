package com.te.resumeBuilder.ResumeDto;

import java.util.List;

import com.te.resumeBuilder.resumeBuilderEntity.EducationalDetails;
import com.te.resumeBuilder.resumeBuilderEntity.ProjectDetails;
import com.te.resumeBuilder.resumeBuilderEntity.TechnicalSkills;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {

	private String firstName;
	private String lastName;
	private String employeeId;
	private String highestEducation;
	private String technology;
	private String totalExperience;
	private String releventExperience;
	private List<String> summary;

	private TechnicalSkills technicalSkills;

	private EducationalDetails educationalDetails;

	private List<ProjectDetails> projectDetails;
}
