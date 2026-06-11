package com.rajat.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AddStudentRequestDto {
    private String name;
    private String email;

    public AddStudentRequestDto( String n, String email) {
        this.name = n;
        this.email = email;
    }
}
