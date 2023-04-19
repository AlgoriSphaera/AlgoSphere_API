package com.sj.algosphere.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sj.algosphere.models.DTO.authentication.SignInRequest;
import com.sj.algosphere.models.DTO.authentication.SignUpRequest;
import com.sj.algosphere.models.entities.User;
import com.sj.algosphere.repositories.UserRepository;
import com.sj.algosphere.services.interfaces.AuthenticationService;
import com.sj.algosphere.utilities.JwtUtil;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private JwtUtil jwtUtils;

    @Override
    public String signUp(SignUpRequest data) throws EmailExistsException {

        User user = userRepository.findByEmail(data.getEmail());

        if(user != null){
            throw new EmailExistsException();
        }

        User newUser = new User();

        newUser.setEmail(data.getEmail());
        newUser.setPassword(passwordEncoder.encode(data.getPassword()));

        userRepository.save(newUser);

        return jwtUtils.generateJwtToken(newUser);

    }

    @Override
    public String signIn(SignInRequest data) throws WrongCredentialsException {

        User user = userRepository.findByEmail(data.getEmail());

        if(user == null){
            throw new WrongCredentialsException(); 
        }

        if(!passwordEncoder.matches(data.getPassword(), user.getPassword())){
            throw new WrongCredentialsException();
        }

        return jwtUtils.generateJwtToken(user);

    }

    public class EmailExistsException extends Exception{
        public EmailExistsException(){
            super("Email already in use!");
        }
    }

    public class WrongCredentialsException extends Exception{
        public WrongCredentialsException(){
            super("Wrong credentials!");
        }
    }
    
}
