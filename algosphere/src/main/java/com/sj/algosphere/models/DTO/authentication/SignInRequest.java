package com.sj.algosphere.models.DTO.authentication;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignInRequest {
    
    @NotNull
    private String email;

    @NotNull
    private String password;
    
}
