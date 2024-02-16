package com.example.logincontroller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.LoginDto;
import com.example.dto.VerifyOtpDTO;
import com.example.logrepo.logRepository;
import com.example.logservice.LogService;
import com.example.logservice.LoginDetService;
import com.example.model.Login_det;


@Controller
public class login {
	
	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;
	
	@Autowired
	private LogService logService;
	
	@Autowired
	private logRepository logrepo;
	
	   @Autowired
	    private LoginDetService loginDetService;
	   
		@Autowired
	    private logRepository repository;
		
	    @GetMapping("/loginDetails")
	    public String showLoginDetails(Model model) {
	        List<Login_det> loginDetails = loginDetService.getLoginDets();
	        model.addAttribute("loginDetails", loginDetails);
	        return "EmpDetails";
	    }
	
	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") LoginDto loginDto) {
		return "register";
	}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") LoginDto loginDto, Model model) {
		logService.save(loginDto);
		model.addAttribute("message", "Registered Successfuly!");
		return "register";
	}
	
	@GetMapping("/login")
	public String llogin() {
		return "login";
	}
	
	
	@GetMapping("/employeeess")
	public String employeees() {
		return "EmpDash";
	}
	
	@GetMapping("user-page")
	public String userPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "user";
	}
	
	@GetMapping("admin-page")
	public String adminPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "admin";
	}

	   @GetMapping("/login-details")
	    public String getAllLoginDetails(Model model) {
	        model.addAttribute("loginDetails", loginDetService.getLoginDets());
	        return "login_details";
	    }

	    @PostMapping("/delete-login-detail")
	    public String deleteLoginDetail(@RequestParam("empid") String empId) {
	        loginDetService.deleteLoginDet(empId);
	        return "redirect:/login-details";
	    }
	    
	    @GetMapping("/forgot")
		public String forgot() {
			return "forgot";
		}
		
		@Autowired
		private LoginDetService userService;
		
		@PostMapping("/sendOtp/{email}")
		public String sendOtpToMail(@PathVariable("email") String email) {
			userService.sendOtpService(email);
			return "otp send successfully";
		}

	    @PostMapping("/resetPassword")
	    public String resetPassword(@ModelAttribute("detail") Login_det user, Model model) {
	        
	        int status = userService.resetPassword(user);
	        
	        if (status == 1) {
	            model.addAttribute("message", "User is not registered");
	            return "forgetPassword";
	        } else if (status == 3) {
	            model.addAttribute("message", "Otp is not matched");
	            return "forgetPassword";
	        }
	        return "login";
	    }

	    
	    @GetMapping("/checkEmailExists/{email}")
	    public ResponseEntity<Map<String, Boolean>> checkEmailExists(@PathVariable String email) {
	    	
	    	Login_det user = repository.findByEmail(email);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("exists", user != null);
	        return ResponseEntity.ok(response);
	    }
	   
	    @PostMapping("/saveEmailAndOTP")
	    public ResponseEntity<String> saveEmailAndOTP(@RequestBody VerifyOtpDTO verifyOtpDTO) {
	        try {
	            userService.saveEmailAndOTP(verifyOtpDTO);
	            return ResponseEntity.ok("Email and OTP saved successfully!");
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body("Error saving email and OTP: " + e.getMessage());
	        }
	    }
	    @GetMapping("/edit-employee-details")
	    public String editEmployeeDetails(Model model, Principal principal) {
	        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
	        model.addAttribute("user", userDetails);
	        return "employee_details";
	    }

	    @PostMapping("/update-employee-details")
	    public String updateEmployeeDetails(@ModelAttribute("user") LoginDto loginDto, Model model) {
	        logService.updateEmployeeDetails(loginDto);
	        model.addAttribute("message", "Employee details updated successfully!");
	        return "employee_details";
	    }
	    

}
