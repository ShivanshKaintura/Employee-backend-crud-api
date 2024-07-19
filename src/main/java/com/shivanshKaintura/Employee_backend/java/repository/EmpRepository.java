package com.shivanshKaintura.Employee_backend.java.repository;

import com.shivanshKaintura.Employee_backend.java.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpRepository extends JpaRepository<Emp,Long> {

}
