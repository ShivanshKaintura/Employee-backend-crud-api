package com.shivanshKaintura.Employee_backend.java.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpDto {
    private Long id;
    private String fName;
    private String lName;
    private String email;
}
