package com.furkankarakus;


import com.furkankarakus.data.entity.EmployeeEntity;
import com.furkankarakus.data.repository.EmployeeRepository;
import com.furkankarakus.test.TestCrud;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.list;
import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
//class PatikaSpringBootApplicationTests implements TestCrud {
//    @Autowired
//    EmployeeRepository employeeRepository;
//
//
//    //CREATE
//    @Test
//    @Override
//    public void testCreate() {
//        EmployeeEntity employeeEntity = EmployeeEntity.builder().firstName("Furkan Test").lastName("Karakus Test").email("furkan@gmail.com").build();
//        employeeRepository.save(employeeEntity);
//        // nesne null ise assertionError hatasi gondersin
//        // 1.kayda gore verileri getir
//        assertNotNull(employeeRepository.findById(1L).get());
//    }
//
//    //LIST
//    @Test
//    @Override
//    public void testList() {
//        List<EmployeeEntity> list = employeeRepository.findAll();
//
//        assertThat(list).size().isGreaterThan(0);
//    }
//    //FINDBYID
//    @Test
//    @Override
//    public void testFindById() {
//      EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();
//      assertEquals("Furkan Test", employeeEntity.getFirstName());
//    }
//    //UPDATE
//    @Test
//    @Override
//    public void testUpdate() {
//        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();
//        employeeEntity.setFirstName("Furkan 01 Test");
//        employeeRepository.save(employeeEntity);
//        assertNotEquals("Furkan Test", employeeRepository.findById(1L).get().getFirstName());
//    }
//    //DELETE
//    @Test
//    @Override
//    public void testDelete() {
//    employeeRepository.deleteById(1L);
//    assertThat(employeeRepository.existsById(1L)).isFalse();
//    }
//}
