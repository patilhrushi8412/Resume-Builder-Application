package com.te.resumeBuilder.resumeController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.resumeBuilder.ResumeDto.ResumeDto;
import com.te.resumeBuilder.responce.ResumeResponce;
import com.te.resumeBuilder.resumeBuilderEntity.ResumeBuilder;
import com.te.resumeBuilder.resumeServices.ResumeServices;

@RestController
public class ResumeController {

	@Autowired
	ResumeServices resumeServices;

	@PostMapping("/addResume")
	public ResponseEntity<ResumeResponce> addResume(@RequestBody ResumeDto builder) {
		ResumeBuilder builder1 = resumeServices.addResume(builder);
		return new ResponseEntity<ResumeResponce>(new ResumeResponce(false, "Resume Added Succesfully", builder1),
				HttpStatus.OK);
	}

	@GetMapping("/getResume/{id}")
	public ResponseEntity<ResumeResponce> GetResume(@PathVariable int id) {
		ResumeBuilder builder1 = resumeServices.getResume(id);
		return new ResponseEntity<ResumeResponce>(new ResumeResponce(false, "Resume Information", builder1),
				HttpStatus.OK);
	}

	@DeleteMapping("/deleteResume/{id}")
	public ResponseEntity<ResumeResponce> deleteResume(@PathVariable int id) {
		resumeServices.deleteResume(id);
		return new ResponseEntity<ResumeResponce>(new ResumeResponce(false, "Deleted Resume Succesfully", null),
				HttpStatus.OK);
	}

	@PutMapping("/updateResume")
	public ResponseEntity<ResumeResponce> updateResume(@RequestBody ResumeBuilder builder) {
		ResumeBuilder builder1 = resumeServices.updateResume(builder);
		return new ResponseEntity<ResumeResponce>(new ResumeResponce(false, "Resume Updated Succesfully", builder1),
				HttpStatus.OK);
	}

	@GetMapping("/getAllResumeByEmployeeID/{employeeId}")
	public ResponseEntity<ResumeResponce> allResumeByEmployeeID(@PathVariable String employeeId) {
		List<ResumeBuilder> builder1 = resumeServices.allResumeByEmployeeID(employeeId);
		return new ResponseEntity<ResumeResponce>(
				new ResumeResponce(false, "All Resume Details By Employee ID", builder1), HttpStatus.OK);
	}

	@GetMapping("/allResumeDetails")
	public ResponseEntity<ResumeResponce> allResumeDetails() {
		List<ResumeBuilder> builder1 = resumeServices.allResumeDetails();
		return new ResponseEntity<ResumeResponce>(new ResumeResponce(false, "All Resume Details", builder1),
				HttpStatus.OK);
	}

	@GetMapping("/allResumeId/{employeeId}")
	public ResponseEntity<ResumeResponce> allResumeId(@PathVariable String employeeId) {
		List<String> builder1 = resumeServices.allResumeId(employeeId);
		return new ResponseEntity<ResumeResponce>(new ResumeResponce(false, "All Resume Ids", builder1), HttpStatus.OK);
	}

	@GetMapping("/getResumeWithEmployeeIdAndResumeId/{employeeId},{resumeId}")
	public ResponseEntity<ResumeResponce> getResumeWithEmployeeIdAndResumeId(@PathVariable String employeeId,
			@PathVariable String resumeId) {
		ResumeBuilder builder1 = resumeServices.getResumeWithEmployeeIdAndResumeId(employeeId, resumeId);
		return new ResponseEntity<ResumeResponce>(new ResumeResponce(false, "Resume Details", builder1), HttpStatus.OK);
	}

}
