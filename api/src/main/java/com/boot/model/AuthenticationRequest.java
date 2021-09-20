package com.boot.model;

import lombok.*;

@Getter @Setter @NoArgsConstructor
public class AuthenticationRequest {
    String username;
    String password;
}
