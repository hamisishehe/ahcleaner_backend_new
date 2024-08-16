package org.example.ahhomeservice.seeder;

import org.example.ahhomeservice.Model.User;
import org.example.ahhomeservice.Model.User.Role;
import org.example.ahhomeservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DatabaseSeeder {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostConstruct
    public void seedDatabase() {
        if (userRepository.count() == 0) {
            User adminUser = new User();
            adminUser.setUsername("admin");
            adminUser.setPhonenumber(1234567890);
            adminUser.setEmail("admin@example.com");
            adminUser.setRole(Role.ADMIN);
            adminUser.setPassword(passwordEncoder.encode("password"));
            adminUser.setEnabled(true);
            adminUser.setLocked(false);

            User customerUser = new User();
            customerUser.setUsername("customer");
            customerUser.setPhonenumber(1234567891);
            customerUser.setEmail("customer@example.com");
            customerUser.setRole(Role.CUSTOMER);
            customerUser.setPassword(passwordEncoder.encode("password"));
            customerUser.setEnabled(true);
            customerUser.setLocked(false);

            userRepository.save(adminUser);
            userRepository.save(customerUser);
        }
    }
}
