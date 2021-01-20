package in.flyspark.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.flyspark.user.entities.User;
import in.flyspark.user.repositories.UserReposiroty;
import in.flyspark.user.vo.Department;
import in.flyspark.user.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	UserReposiroty userReposiroty;

	@Autowired
	RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("saveUser in UserService");
		return userReposiroty.save(user);
	}

	public User findByUserId(Long userId) {
		log.info("findByUserId in UserService");
		return userReposiroty.findByUserId(userId);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("getUserWithDepartment in UserService");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userReposiroty.findByUserId(userId);
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
				Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}

}
