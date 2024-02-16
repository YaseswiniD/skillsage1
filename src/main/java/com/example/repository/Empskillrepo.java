package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.EmpID;
import com.example.entity.EmployeeSkill;
import com.example.entity.Skills;
//import com.example.entity.User;
import com.example.model.Login_det;




@Repository
public interface Empskillrepo extends JpaRepository<EmployeeSkill, EmpID> {

    List<EmployeeSkill> findById_Empid(String empid);
    EmployeeSkill findById_EmpidAndId_Skillid(String empid, Integer skillid);
    List<EmployeeSkill> findById_Skillid(Integer skillid);
  
    
}

