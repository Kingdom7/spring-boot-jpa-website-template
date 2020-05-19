package za.saziso.loginregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.saziso.loginregistration.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
