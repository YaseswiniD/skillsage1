package com.example.logservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dto.LoginDto;
import com.example.logrepo.logRepository;
import com.example.model.Login_det;

@Service
public class LogServiceImpl implements LogService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private logRepository logRepository;
	
	 @Override
	    public Login_det save(LoginDto loginDto) {
	        // Create a new Login_det object with all fields from LoginDto
	        Login_det login_det = new Login_det(
	            loginDto.getEmpid(), 
	            loginDto.getEmail(), 
	            passwordEncoder.encode(loginDto.getPassword()), 
	            loginDto.getRole(), 
	            loginDto.getFullname(), 
	            loginDto.getProject(), 
	            loginDto.getPro_desc(), 
	            loginDto.getDateFrom(), 
	            loginDto.getDateTo(),
	            loginDto.getDesignation() // Add the designation field
	        );
	        return logRepository.save(login_det); // Save the object
	    }
	


	@Override
	public Login_det getEmployeeById(long long1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	 @Override
	    public void updateEmployeeDetails(LoginDto loginDto) {
	        // Find the existing Login_det object by empid
	        Login_det existingLoginDet = logRepository.findByEmpid(loginDto.getEmpid());
	        if (existingLoginDet != null) {
	            // Update the fields with values from LoginDto
	            existingLoginDet.setEmail(loginDto.getEmail());
	            existingLoginDet.setFullname(loginDto.getFullname());
	            existingLoginDet.setProject(loginDto.getProject());
	            existingLoginDet.setPro_desc(loginDto.getPro_desc());
	            existingLoginDet.setDateFrom(loginDto.getDateFrom());
	            existingLoginDet.setDateTo(loginDto.getDateTo());
	            existingLoginDet.setDesignation(loginDto.getDesignation()); // Set the designation field
	            logRepository.save(existingLoginDet); // Save the updated object
	        }
	    }

}
