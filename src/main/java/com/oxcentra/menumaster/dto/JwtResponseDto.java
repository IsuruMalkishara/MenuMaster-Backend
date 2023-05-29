package com.oxcentra.menumaster.dto;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponseDto {
    private int user_id;
    private Boolean result;
    private String message;
    private String access_token;
    private Date expires_at;
    private int expires_in;
}
