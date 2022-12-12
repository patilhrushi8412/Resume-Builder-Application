package com.te.resumeBuilder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.resumeBuilder.resumeBuilderEntity.ResumeBuilder;

@Repository
public interface ResumeReporesitory extends JpaRepository<ResumeBuilder, Integer> {

	List<ResumeBuilder> findAllByEmployeeId(String employeeId);

	ResumeBuilder findByEmployeeIdAndResumeId(String employeeId, String resumeId);
}
