package com.furkankarakus.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
@Data
@NoArgsConstructor
@Log4j2
@Builder
@AllArgsConstructor

@Entity
@Table(name = "employees")
@EqualsAndHashCode(callSuper = false)
public class EmployeeEntity extends BaseEntity implements Serializable {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_name")
    private String emailId;

}
