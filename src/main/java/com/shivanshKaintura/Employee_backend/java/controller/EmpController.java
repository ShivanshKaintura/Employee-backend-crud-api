package com.shivanshKaintura.Employee_backend.java.controller;

import com.shivanshKaintura.Employee_backend.java.dto.EmpDto;
import com.shivanshKaintura.Employee_backend.java.service.EmpService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmpController {

    private EmpService empService;

    // Build add employee Rest API
    @PostMapping
    public ResponseEntity<EmpDto> createEmployee(@RequestBody EmpDto empDto){
        EmpDto savedEmployee=empService.createEmp(empDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Build get employee REST API
    @GetMapping("{id}")
    public ResponseEntity<EmpDto> getEmployeeById(@PathVariable("id") Long empId){
        EmpDto empDto = empService.getEmpById(empId);
        return  ResponseEntity.ok(empDto);
    }

    //Build get all employees REST API
    @GetMapping
    public ResponseEntity<List<EmpDto>> getAllEmployees(){
        List<EmpDto>employees = empService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //Build Update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<EmpDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmpDto updatedEmployee){
        EmpDto employeeDto = empService.updateEmployee(employeeId,updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    //Build Delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        empService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully");
    }


}
