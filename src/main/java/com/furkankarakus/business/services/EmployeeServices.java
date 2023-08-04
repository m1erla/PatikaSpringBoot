package com.furkankarakus.business.services;


import com.furkankarakus.business.dto.EmployeeDto;
import com.furkankarakus.data.entity.EmployeeEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface EmployeeServices {
    //CRUD

    public List<EmployeeDto> getAllEmployees();
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto);
    public ResponseEntity<EmployeeDto> getEmployeeById(Long id);

    public ResponseEntity<EmployeeDto> updateEmployee(Long id, EmployeeDto employeeDto);

    public ResponseEntity<Map<String,Boolean>> deleteEmployee(Long id);

    //Model Mapper

    public EmployeeDto EntityToDto(EmployeeEntity employeeEntity);
    public EmployeeEntity DtoToEntity(EmployeeDto employeeDto);
}
