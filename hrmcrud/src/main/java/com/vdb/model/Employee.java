package com.vdb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    private String empName;

    private String empAddress;

    private double empSalary;

    @Column(unique = true)
    private int empContact;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empDob;

}
