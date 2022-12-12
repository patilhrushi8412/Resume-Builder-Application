package com.te.resumeBuilder.resumeServices;

import java.util.List;

import com.te.resumeBuilder.ResumeDto.ResumeDto;
import com.te.resumeBuilder.resumeBuilderEntity.ResumeBuilder;

public interface ResumeServices {

	ResumeBuilder addResume(ResumeDto builder);

	ResumeBuilder getResume(int id);

	void deleteResume(int id);

	ResumeBuilder updateResume(ResumeBuilder builder);

	List<ResumeBuilder> allResumeDetails();

	List<ResumeBuilder> allResumeByEmployeeID(String employeeId);

	List<String> allResumeId(String employeeId);

	ResumeBuilder getResumeWithEmployeeIdAndResumeId(String employeeId, String resumeId);

}
