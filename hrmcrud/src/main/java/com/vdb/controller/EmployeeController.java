package com.vdb.controller;

import com.vdb.exception.RecordNotFoundException;
import com.vdb.model.Employee;
import com.vdb.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<Employee> save(@RequestBody Employee employee)
    {
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @GetMapping("/findById/{empId}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable int empId)
    {
        return ResponseEntity.ok(employeeService.findById(empId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Employee>> findAll()
    {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<Employee> update(@PathVariable int empId,Employee employee)
    {
        Employee employee1=employeeService.findById(empId).orElseThrow(()->new RecordNotFoundException("Employee #Id not Found"));

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpContact(employee.getEmpContact());
        employee1.setEmpDob(employee.getEmpDob());

        return ResponseEntity.ok(employeeService.update(employee1));
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> delete(@PathVariable int empId)
    {
        employeeService.delete(empId);
        return ResponseEntity.ok("Employee Deleted Successfully .............");
    }

}
