package com.example.logservice;



import java.security.SecureRandom;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dto.LoginDto;
import com.example.dto.VerifyOtpDTO;
import com.example.logrepo.logRepository;
import com.example.model.Login_det;
import com.example.service.EmpSkillService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;


@Service
public class LoginDetService {
    @Autowired
    private logRepository repository;
    
    @Autowired
    private JavaMailSender javaMailSender;
    
    

    public Login_det saveLoginDet(Login_det loginDet) {
        return repository.save(loginDet);
    }

    public List<Login_det> saveLoginDets(List<Login_det> loginDets) {
        return repository.saveAll(loginDets);
    }

    public List<Login_det> getLoginDets() {
        return repository.findAll();
    }

    public Login_det getLoginDetByEmpId(String empid) {
        return repository.findByEmpid(empid).orElse(null);
    }

    public Login_det getLoginDetByEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }
    
    @Autowired
   	private EmpSkillService service;

       @Transactional
       public void deleteLoginDet(String empId) {
       	service.deleteEmpSkillByEmpId(empId);
           repository.deleteByEmpid(empId);
           
       }
    
       public Login_det updateLoginDet(Login_det updatedUser) {
           // Perform any necessary validation or business logic
           return repository.save(updatedUser);
       }

//    public String deleteLoginDet(String empId) {
//        repository.deleteById(empId);
//        return "Login Details removed!! " + empId;
//    }

//    public Login_det updateLoginDet(Login_det loginDet) {
//        Login_det existingLoginDet = repository.findByEmpid(loginDet.getEmpid()).orElse(null);
//        existingLoginDet.setEmail(loginDet.getEmail());
//        existingLoginDet.setPassword(loginDet.getPassword());
//        existingLoginDet.setRole(loginDet.getRole());
//        existingLoginDet.setFullname(loginDet.getFullname());
//        return repository.save(existingLoginDet);
//    }

    public List<LoginDto> getAllEmployeeDetails() {
        // TODO: Implement logic for fetching employee details
        return null;
    }

    public List<LoginDto> searchEmployees(String empId, String skillname, String domain, String subdomain,
            String proficiency) {
        // TODO: Implement logic for searching employees
        return null;
    }
    
    public void sendOtpService(String email) {
		String otp=generateOtp();
		//System.out.print(email);
		if (otp == null) 
		{
            throw new RuntimeException("Failed to generate OTP");
        }
		
		Login_det user = repository.findByEmail(email);
		if (user==null)
		{
			 user=new Login_det();
		}
		
		user.setEmail(email);
		
		user.setOtp(otp);
		repository.save(user);
		try {
			sendOtpToMail(email,otp);
			
		}catch(MessagingException e) {
			throw new RuntimeException("unable to send otp");
		}
		
	}
	public String generateOtp() {
		SecureRandom random=new SecureRandom();
		int otp= 100000 + random.nextInt(900000);
		return String.valueOf(otp);
	}
	
	private void sendOtpToMail(String email,String otp) throws MessagingException {
		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage);
		mimeMessageHelper.setTo(email);
		mimeMessageHelper.setSubject("Your OTP is:");
		mimeMessageHelper.setText(otp);
		javaMailSender.send(mimeMessage);
				
	}


	public boolean verifyOtp(String email, String otp) {
		Login_det user = repository.findByEmail(email);
		 if (user.getOtp() .equals(otp))
		 {
			 return true;
		 }
		return false;
	}

	
	public int resetPassword(Login_det user) {
		Login_det user1 = repository.findByEmail(user.getEmail());
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		if (user1==null) {
			return 1;
		}
		 if (user1.getOtp() .equals(user.getOtp())){
			 String password=encoder.encode(user.getPassword());
			 user1.setPassword(password);
			 repository.save(user1);
			 return 2;
		 }
		 return 3;
		 
	}
	
	    @Transactional
	    public void saveEmailAndOTP(VerifyOtpDTO verifyOtpDTO) {
	        String email = verifyOtpDTO.getEmail();
	        String otp = verifyOtpDTO.getOtp();

	        Login_det user = repository.findByEmail(email);

	        // Only save email and OTP if the user does not exist
	        if (user == null) {
	            user = new Login_det();
	            user.setEmail(email);
	            user.setOtp(otp);
	            repository.save(user);
	        }
	    }
}

