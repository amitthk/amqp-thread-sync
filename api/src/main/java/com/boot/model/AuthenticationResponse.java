package com.boot.model;
import lombok.*;

@Getter @Setter
public class AuthenticationResponse {

    private String bearer;
    public AuthenticationResponse(String bearer) {
        this.bearer=bearer;
    }
}
