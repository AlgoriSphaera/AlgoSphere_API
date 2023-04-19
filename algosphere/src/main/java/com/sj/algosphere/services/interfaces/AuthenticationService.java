package com.sj.algosphere.services.interfaces;

import com.sj.algosphere.models.DTO.authentication.SignInRequest;
import com.sj.algosphere.models.DTO.authentication.SignUpRequest;
import com.sj.algosphere.services.AuthenticationServiceImpl.EmailExistsException;
import com.sj.algosphere.services.AuthenticationServiceImpl.WrongCredentialsException;

public interface AuthenticationService {

    String signUp(SignUpRequest data) throws EmailExistsException;
    String signIn(SignInRequest data) throws WrongCredentialsException;
    
}
