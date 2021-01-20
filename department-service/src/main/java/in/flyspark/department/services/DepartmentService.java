package in.flyspark.department.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.flyspark.department.entities.Department;
import in.flyspark.department.repositories.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		log.info("saveDepartment in DepartmentService");
		return departmentRepository.save(department);
	}

	public Department findByDepartmentId(Long departmentId) {
		log.info("findDepartmentById in DepartmentService");
		return departmentRepository.findByDepartmentId(departmentId);
	}

}
