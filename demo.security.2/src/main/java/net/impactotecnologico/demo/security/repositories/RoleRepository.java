package net.impactotecnologico.demo.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.impactotecnologico.demo.security.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}