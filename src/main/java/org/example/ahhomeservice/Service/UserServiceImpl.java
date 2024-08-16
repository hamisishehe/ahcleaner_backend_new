package org.example.ahhomeservice.Service;

import org.example.ahhomeservice.Model.User;
import org.example.ahhomeservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public void saveUser(User user) {

    }

    public User userbyemail(String email){
        Optional<User> user = userRepository.findByEmail(email);
        return user.orElse(null);
    }

    @Override
    public List<Object> isUserPresent(User user) {
        return List.of();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public void deleteUser(Long id) {

    }

    public User registration(User user, String email, String password, String username, int phonenumber){
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(User.Role.CUSTOMER);
        user.setEnabled(true);
        user.setPhonenumber(phonenumber);
        return userRepository.save(user);
    }

    public User registrationfromadmin(User user, String email, String role, String username, int phonenumber){
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(username));
        user.setRole(User.Role.valueOf(role));
        user.setEnabled(true);
        user.setPhonenumber(phonenumber);


        return userRepository.save(user);
    }


    public Optional<User> userDetails(String email){
        return userRepository.findByEmail(email);
    }

    public Long countall(){
        Long count = userRepository.count();
        return count;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(
                ()-> new UsernameNotFoundException(
                        String.format("USER_NOT_FOUND", email)
                ));
    }
}
