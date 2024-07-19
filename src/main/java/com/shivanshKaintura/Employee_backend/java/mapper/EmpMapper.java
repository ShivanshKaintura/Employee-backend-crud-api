package com.shivanshKaintura.Employee_backend.java.mapper;

import com.shivanshKaintura.Employee_backend.java.dto.EmpDto;
import com.shivanshKaintura.Employee_backend.java.entity.Emp;

public class EmpMapper {

    public static  EmpDto mapToEmpDto(Emp emp) {

      return new EmpDto(
              emp.getId(),
              emp.getFName(),
              emp.getLName(),
              emp.getEmail()
      );
    }

    public static Emp mapToEmp(EmpDto empDto){
        return new Emp(
                empDto.getId(),
                empDto.getFName(),
                empDto.getLName(),
                empDto.getEmail()
        );
    }
}
