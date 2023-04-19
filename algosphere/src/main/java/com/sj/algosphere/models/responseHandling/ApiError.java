package com.sj.algosphere.models.responseHandling;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiError {
    
    private String errorCode;
    private String message;

}
