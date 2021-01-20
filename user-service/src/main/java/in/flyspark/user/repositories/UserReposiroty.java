package in.flyspark.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.flyspark.user.entities.User;

public interface UserReposiroty extends JpaRepository<User, Long> {

	User findByUserId(Long userId);

}
