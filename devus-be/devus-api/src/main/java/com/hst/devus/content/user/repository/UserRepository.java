package com.hst.devus.content.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hst.devus.content.user.entity.User;

/**
 * @author dlgusrb0808@gmail.com
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsname(String usname);

}
