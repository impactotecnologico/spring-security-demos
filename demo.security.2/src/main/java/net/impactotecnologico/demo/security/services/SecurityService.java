package net.impactotecnologico.demo.security.services;

public interface SecurityService {
	String findLoggedInUsername();

	void autoLogin(String username, String password);
}