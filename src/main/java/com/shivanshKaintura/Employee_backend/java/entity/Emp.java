package com.shivanshKaintura.Employee_backend.java.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @Column(name = "f_Name")
    private String fName;
    @Column(name = "l_Name")
    private String lName;
    @Column(name = "email_id",unique = true,nullable = false)
    private String email;
}
