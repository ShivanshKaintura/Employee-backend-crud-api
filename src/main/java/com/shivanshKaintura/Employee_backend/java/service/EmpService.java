package com.shivanshKaintura.Employee_backend.java.service;

import com.shivanshKaintura.Employee_backend.java.dto.EmpDto;
import com.shivanshKaintura.Employee_backend.java.entity.Emp;

import java.util.List;

public interface EmpService {
    EmpDto createEmp(EmpDto empDto);

    EmpDto getEmpById(Long empId);

    List<EmpDto> getAllEmployees();

    EmpDto updateEmployee(Long employeeId,EmpDto updatedEmployee);

    void deleteEmployee(Long employeeId);
}
