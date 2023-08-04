package com.furkankarakus.business.services.impl;


import com.furkankarakus.business.dto.EmployeeDto;
import com.furkankarakus.business.services.EmployeeServices;
import com.furkankarakus.data.entity.EmployeeEntity;
import com.furkankarakus.data.repository.EmployeeRepository;
import com.furkankarakus.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class EmployeeServiceImpl implements EmployeeServices {
    @Autowired
    public EmployeeRepository employeeRepository;
    @Autowired
    public ModelMapper modelMapper;
    //LIST
    // http://localhost:8080/api/employees
    @GetMapping("/employees")
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> listDto = new ArrayList<>();
        Iterable<EmployeeEntity> teacherList = employeeRepository.findAll();
        for(EmployeeEntity entity: teacherList){
            EmployeeDto employeeDto = EntityToDto(entity);
            listDto.add(employeeDto);
        }
        return listDto;
    }

   //FIND
    // http://localhost:8080/api/employees/1
    @GetMapping(name = "/employees/{id}")
    @Override
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name = "id") Long id){
        EmployeeEntity employeeEntity = (EmployeeEntity) employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id :" + id));
        EmployeeDto employeeDto = EntityToDto(employeeEntity);//model
        return ResponseEntity.ok(employeeDto);
    }
    //SAVE
    // http://localhost:8080/api/employees
    @PostMapping("/employees")
    @Override
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeEntity employeeEntity = DtoToEntity(employeeDto);//ModelMapper
        employeeRepository.save(employeeEntity);
        return employeeDto;
    }


    //UPDATE
    // http://localhost:8080/api/employees
    @PutMapping("/employees/{id}")
    @Override
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(name = "id") Long id,@RequestBody EmployeeDto employeeDetails){
        EmployeeEntity employeeEntity = DtoToEntity(employeeDetails);//ModelMapper
        EmployeeEntity employee =employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id :" + id));

        employee.setFirstName(employee.getFirstName());
        employee.setLastName(employee.getLastName());
        employee.setEmailId(employee.getEmailId());

        EmployeeEntity updateEmployee = employeeRepository.save(employee);
        EmployeeDto employeeDto = EntityToDto(updateEmployee);//model
        return ResponseEntity.ok(employeeDto);
    }
    //DELETE
    // http://localhost:8080/api/employees
    @DeleteMapping("/employees/{id}")
    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable(name = "id") Long id){
        EmployeeEntity employeeEntity =employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id :" + id));
        employeeRepository.delete(employeeEntity);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
    ///////////////////////////////////////
    //Model Mapper Entity ==> Dto
    @Override
    public EmployeeDto EntityToDto(EmployeeEntity employeeEntity) {
        EmployeeDto employeeDto = modelMapper.map(employeeEntity, EmployeeDto.class);
        return employeeDto;
    }

    // Model Mapper Dto ==> Entity
    @Override
    public EmployeeEntity DtoToEntity(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);

        return employeeEntity;
    }
}
