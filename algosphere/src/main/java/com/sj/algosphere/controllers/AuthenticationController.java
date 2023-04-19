package com.sj.algosphere.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sj.algosphere.models.DTO.authentication.SignInRequest;
import com.sj.algosphere.models.DTO.authentication.SignUpRequest;
import com.sj.algosphere.models.responseHandling.ApiErrorBuilder;
import com.sj.algosphere.models.responseHandling.BaseResponse;
import com.sj.algosphere.models.responseHandling.errorCodes.AuthenticationErrorCodes;
import com.sj.algosphere.models.responseHandling.errorCodes.BaseApiErrorCodes;
import com.sj.algosphere.services.AuthenticationServiceImpl;
import com.sj.algosphere.services.interfaces.AuthenticationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/signUp")
    public BaseResponse register(@RequestBody @Valid SignUpRequest rq){
        BaseResponse response = new BaseResponse();

        try{
            String token = authenticationService.signUp(rq);

            response.setSuccess(true);
            response.setResult(token);

        } catch (AuthenticationServiceImpl.EmailExistsException ex){
            
            ApiErrorBuilder.build(response, AuthenticationErrorCodes.EMAIL_ALREADY_IN_USE);

        } catch (Exception ex) {

            ApiErrorBuilder.build(response, BaseApiErrorCodes.UNKNOWN_ERROR);

        }

        return response;
    }

    @PostMapping("/signIn")
    public BaseResponse login(@RequestBody @Valid SignInRequest rq){
        BaseResponse response = new BaseResponse();

        try{

            String token = authenticationService.signIn(rq);

            response.setSuccess(true);
            response.setResult(token);

        } catch (AuthenticationServiceImpl.WrongCredentialsException ex){

            ApiErrorBuilder.build(response, AuthenticationErrorCodes.WRONG_CREDETIALS);

        } catch (Exception ex) {

            ApiErrorBuilder.build(response, BaseApiErrorCodes.UNKNOWN_ERROR);

        }

        return response;
    }
    
}
