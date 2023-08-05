package com.furkankarakus.security.jwt;
//we will use for register

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.furkankarakus.data.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

//lombok
@Getter
@Setter

//Jpa
@Entity
@Table(name = "user")
public class _02_UserEntity extends BaseEntity {

    @Column
    private String username;

    @Column
    @JsonIgnore
    private String password;

    @Column(name = "system_auto_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date date;
}
