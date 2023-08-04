package com.furkankarakus.ui.rest;

import com.furkankarakus.business.dto.EmployeeDto;
import com.furkankarakus.business.services.EmployeeServices;
import com.furkankarakus.data.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
    @Autowired
    EmployeeServices employeeServices;

    //ROOT
    // http://localhost:8080/api/index
    @GetMapping({"/index","/"})
    public String getRoot(){
        return "index";
    }

    //LIST
    //http://localhost:8080/api/employees
    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees(){
        List<EmployeeDto> employeeDtoList = employeeServices.getAllEmployees();
        return employeeDtoList;
    }
    //FIND
    //http://localhost:8080/api/employees/1
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name = "id")Long id){
        ResponseEntity<EmployeeDto> employeeDtoResponseEntity = employeeServices.getEmployeeById(id);
        return employeeDtoResponseEntity;
    }
    //SAVE
    //http://localhost:8080/api/employees
    @PostMapping("/employees")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto){
        employeeServices.createEmployee(employeeDto);
        return employeeDto;
    }

    //UPDATE
    //http://localhost:8080/api/employees/1
    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(name = "id") Long id, @RequestBody EmployeeDto employeeDto){
        employeeServices.updateEmployee(id, employeeDto);
        return ResponseEntity.ok(employeeDto);

    }
    //DELETE
    //http://localhost:8080/api/employees/1
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable(name = "id") Long id){
        employeeServices.deleteEmployee(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
