package in.flyspark.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.flyspark.user.entities.User;
import in.flyspark.user.services.UserService;
import in.flyspark.user.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/")
	public User saveUser(@RequestBody User department) {
		log.info("saveUser in UserController");
		return userService.saveUser(department);
	}

	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
		log.info("getUserWithDepartment in UserController");
		return userService.getUserWithDepartment(userId);
	}
}
