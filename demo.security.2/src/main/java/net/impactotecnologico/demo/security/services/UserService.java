package net.impactotecnologico.demo.security.services;

import net.impactotecnologico.demo.security.models.User;

public interface UserService {
	void save(User user);

	User findByUsername(String username);
}