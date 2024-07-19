package com.shivanshKaintura.Employee_backend.java.service.implementation;

import com.shivanshKaintura.Employee_backend.java.dto.EmpDto;
import com.shivanshKaintura.Employee_backend.java.entity.Emp;
import com.shivanshKaintura.Employee_backend.java.exception.ResourceNotFoundException;
import com.shivanshKaintura.Employee_backend.java.mapper.EmpMapper;
import com.shivanshKaintura.Employee_backend.java.repository.EmpRepository;
import com.shivanshKaintura.Employee_backend.java.service.EmpService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmpImpl implements EmpService {

    private EmpRepository empRepository;

    @Override
    public EmpDto createEmp(EmpDto empDto) {

        Emp emp= EmpMapper.mapToEmp(empDto);
        Emp savedEmp = empRepository.save(emp);
        return EmpMapper.mapToEmpDto(savedEmp);
    }

    @Override
    public EmpDto getEmpById(Long empId) {
        Emp employee =empRepository.findById(empId).orElseThrow(()->
                new ResourceNotFoundException("Employee id does not exists with id : "+empId));

        return EmpMapper.mapToEmpDto(employee);
    }

    @Override
    public List<EmpDto> getAllEmployees() {
        List<Emp> employees=empRepository.findAll();
        // return employees.stream().map((employee)-> EmpMapper.mapToEmpDto(employee)).collect(Collectors.toList());
        return employees.stream().map(EmpMapper::mapToEmpDto).collect(Collectors.toList());
    }

    @Override
    public EmpDto updateEmployee(Long employeeId, EmpDto updatedEmployee) {

        Emp employee = empRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException(" Employee does not exits with given id : "+employeeId));

        employee.setFName(updatedEmployee.getFName());
        employee.setLName(updatedEmployee.getLName());
        employee.setEmail(updatedEmployee.getEmail());

        Emp updatedEmployeeObj = empRepository.save(employee);

        return EmpMapper.mapToEmpDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Emp employee = empRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException(" Employee does not exits with given id : "+employeeId));

        empRepository.deleteById(employeeId);
    }
}
