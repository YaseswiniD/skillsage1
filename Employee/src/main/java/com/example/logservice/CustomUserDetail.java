package com.example.logservice;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.model.Login_det;

public class CustomUserDetail implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Login_det login_det;
	
	public CustomUserDetail(Login_det login_det) {
		this.login_det = login_det;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(() -> login_det.getRole());
	}
	
	public String getFullname() {
		return login_det.getFullname();
	}

	@Override
	public String getPassword() {
		return login_det.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login_det.getEmpid();
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return login_det.getEmail();
	}

	public String getEmpid() {
		return login_det.getEmpid();
	}
	
	
	 public String getProject() {
	        return login_det.getProject();
	    }

	    public String getPro_desc() {
	        return login_det.getPro_desc();
	    }

	    public Date getDateFrom() {
	        return login_det.getDateFrom();
	    }

	    public Date getDateTo() {
	        return login_det.getDateTo();
	    }
	 // New method to retrieve the designation
	    public String getDesignation() {
	        return login_det.getDesignation();
	    }

	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
