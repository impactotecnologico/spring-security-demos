package net.impactotecnologico.demo.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.impactotecnologico.demo.security.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}