package com.sj.algosphere.models.responseHandling;

import com.sj.algosphere.models.responseHandling.errorCodes.AuthenticationErrorCodes;
import com.sj.algosphere.models.responseHandling.errorCodes.BaseApiErrorCodes;

public class ApiErrorBuilder {

    public static void build(BaseResponse response, String errorCode){

        ApiError apiError = new ApiError();

        apiError.setErrorCode(errorCode);

        switch(errorCode) {

            case BaseApiErrorCodes.UNKNOWN_ERROR -> {
                apiError.setMessage("Unknown error!");
            }
            case AuthenticationErrorCodes.EMAIL_ALREADY_IN_USE -> {
                apiError.setMessage("Email already in use!");
            }
            case AuthenticationErrorCodes.WRONG_CREDETIALS -> {
                apiError.setMessage("Wrong credentials!");
            }
            case AuthenticationErrorCodes.NOT_AUTHENTICATED -> {
                apiError.setMessage("Not authenticated!");
            }

        }

        response.setError(apiError);

    }
    
}
