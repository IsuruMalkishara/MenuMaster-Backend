package com.oxcentra.menumaster.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequestDto {
    private String email;
    private String password;
}
