package in.flyspark.department.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.flyspark.department.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department findByDepartmentId(Long departmentId);

}
