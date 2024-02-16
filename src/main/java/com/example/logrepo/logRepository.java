
package com.example.logrepo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Login_det;

@Repository
public interface logRepository extends JpaRepository<Login_det, String> {
    
	Login_det findByEmail (String email);
	Login_det findByEmpid (String empid);
	 void deleteByEmpid(String empId);

}
