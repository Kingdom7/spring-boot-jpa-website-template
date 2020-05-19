package za.saziso.loginregistration.service;

import za.saziso.loginregistration.model.User;

public interface UserService {
	
	// For registration section
    void save(User user);

    // For login section
    User findByUsername(String username);
}
