package com.te.resumeBuilder.resumeBuilderEntity;

import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.te.resumeBuilder.converter.ListToStringConverter;

import lombok.Data;

@Data
@Entity
public class ProjectDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectid;
	
	@Convert(converter = ListToStringConverter.class)
	private List<String> frontendTechnologies;
	@Convert(converter = ListToStringConverter.class)
	private List<String> backendTechnologies;
	@Convert(converter = ListToStringConverter.class)
	private List<String> designPatterns;
	@Convert(converter = ListToStringConverter.class)
	private List<String> databasesUsed;
	@Convert(converter = ListToStringConverter.class)
	private List<String> developmentTools;
	private String duration;
	private int teamSize;
	private String rolrAndResponsibility;
}
