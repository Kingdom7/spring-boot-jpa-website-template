package za.saziso.loginregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.saziso.loginregistration.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
