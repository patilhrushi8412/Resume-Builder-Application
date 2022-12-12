package com.te.resumeBuilder.resumeServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.resumeBuilder.ResumeDto.ResumeDto;
import com.te.resumeBuilder.repository.ResumeReporesitory;
import com.te.resumeBuilder.resumeBuilderEntity.ResumeBuilder;
import com.te.resumeBuilder.resumeCustomException.ResumeCustomException;

@Service
public class ResumeServicesImpl implements ResumeServices {

	@Autowired
	ResumeReporesitory reporesitory;

	@Override
	public ResumeBuilder addResume(ResumeDto builder) {
		try {
			ResumeBuilder builderfirst = new ResumeBuilder();
			BeanUtils.copyProperties(builder, builderfirst);
			if (builder == null) {
				throw new ResumeCustomException("Resume Details Not Filled Proper");
			} else {

				List<ResumeBuilder> list = reporesitory.findAllByEmployeeId(builderfirst.getEmployeeId());
				int count = 1;
				if (!list.isEmpty()) {
					for (int i = 0; i <= list.size(); i++) {
						count = i + 1;
					}
				}
				builderfirst.setResumeId("RES_" + builder.getTotalExperience() + "_" + count);
				ResumeBuilder save = reporesitory.save(builderfirst);
				return save;
			}
		} catch (ResumeCustomException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public ResumeBuilder getResume(int id) {
		try {
			Optional<ResumeBuilder> findById = reporesitory.findById(id);
			if (!findById.isPresent()) {
				throw new ResumeCustomException("Resume Details Not Present");
			} else {
				return findById.get();
			}
		} catch (ResumeCustomException e) {
			throw e;
		}
	}

	@Override
	public void deleteResume(int id) {
		try {
			Optional<ResumeBuilder> findById = reporesitory.findById(id);
			if (!findById.isPresent()) {
				throw new ResumeCustomException("Resume Details Not Present On This ID");
			} else {
				reporesitory.deleteById(id);
			}
		} catch (ResumeCustomException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public ResumeBuilder updateResume(ResumeBuilder builder) {
		try {
			Optional<ResumeBuilder> findById = reporesitory.findById(builder.getId());
			if (!findById.isPresent()) {
				throw new ResumeCustomException("Resume Details Not Present On This ID");
			} else {
				BeanUtils.copyProperties(builder, findById.get());
				ResumeBuilder save = reporesitory.save(findById.get());
				return save;
			}
		} catch (ResumeCustomException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<ResumeBuilder> allResumeDetails() {
		try {
			List<ResumeBuilder> findAll = reporesitory.findAll();
			if (findAll.isEmpty()) {
				throw new ResumeCustomException("Resumes Not Presents");
			} else {
				return findAll;
			}
		} catch (ResumeCustomException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<ResumeBuilder> allResumeByEmployeeID(String employeeId) {
		try {
			List<ResumeBuilder> list = reporesitory.findAllByEmployeeId(employeeId);
			if (list.isEmpty()) {
				throw new ResumeCustomException("Employee ID Not Present");
			} else {
				return list;
			}
		} catch (ResumeCustomException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<String> allResumeId(String employeeId) {
		try {
			List<ResumeBuilder> findAllByEmployeeId = reporesitory.findAllByEmployeeId(employeeId);
			if (findAllByEmployeeId.isEmpty()) {
				throw new ResumeCustomException("Resumes Are Not Presents");
			} else {
				List<String> list = new ArrayList<>();
				for (int i = 0; i < findAllByEmployeeId.size(); i++) {
					String resumeId = findAllByEmployeeId.get(i).getResumeId();
					list.add(resumeId);
				}
				return list;
			}

		} catch (ResumeCustomException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public ResumeBuilder getResumeWithEmployeeIdAndResumeId(String employeeId, String resumeId) {
		try {
			ResumeBuilder employeeIdAndresumeId = reporesitory.findByEmployeeIdAndResumeId(employeeId, resumeId);
			if (employeeIdAndresumeId == null) {
				throw new ResumeCustomException("Resume Not Found");
			} else {
				return employeeIdAndresumeId;
			}
		} catch (ResumeCustomException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}
}
