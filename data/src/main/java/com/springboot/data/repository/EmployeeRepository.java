package com.springboot.data.repository;

import java.util.List;

import com.springboot.data.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author tanglei
 * @date 2020/1/20
 */
@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query(value = "select * from jpa_employee where age >= ?1 and age <= ?2",nativeQuery = true)
    List<Employee> findAll(Integer startAge,Integer endAge);

    @Query(value = "select * from jpa_employee where age >= :startAge and age <= :endAge",nativeQuery = true)
    List<Employee> findAlla(@Param("startAge") Integer startAge, @Param("endAge")Integer endAge);
}