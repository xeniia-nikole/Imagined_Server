package com.example.demo.dataTransferObject;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserDTO {

    private Long id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String name;
    private String surname;
    private String bio;

}
