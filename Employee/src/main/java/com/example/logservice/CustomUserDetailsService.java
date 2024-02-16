package com.example.logservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.logrepo.logRepository;
import com.example.model.Login_det;

@Service
@Primary
public class CustomUserDetailsService implements UserDetailsService {
	
	 @Autowired
	 private logRepository logRepository;

	@Override
	public UserDetails loadUserByUsername(String empid) throws UsernameNotFoundException {
		Login_det login_det = logRepository.findByEmpid(empid);
		if (login_det == null) {
			throw new UsernameNotFoundException("user not found");
		}
		
		return new CustomUserDetail(login_det);

	}

}
