package com.example.entity;



import com.example.model.Login_det;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Transactional
@Table(name = "EmployeeSkill")
@Entity
public class EmployeeSkill {
	
    
	@EmbeddedId
    private EmpID id;

	    @ManyToOne
	    @JoinColumn(name = "empid", insertable = false, updatable = false)
	    private Login_det login_det;

	    @ManyToOne
	    @JoinColumn(name = "skillid", insertable = false, updatable = false)
	    private Skills skills;

	    private String proficiency;
	    private String exp;
	    private String cert_source;
	    
	    
	    
	    
		public EmpID getId() {
			return id;
		}
		public void setId(EmpID id) {
			this.id = id;
		}
		

		public Login_det getLogin_det() {
			return login_det;
		}
		public void setLogin_det(Login_det login_det) {
			this.login_det = login_det;
		}
		public Skills getSkills() {
			return skills;
		}
		public void setSkills(Skills skills) {
			this.skills = skills;
		}
		public String getProficiency() {
			return proficiency;
		}
		public void setProficiency(String proficiency) {
			this.proficiency = proficiency;
		}
		public String getExp() {
			return exp;
		}
		public void setExp(String exp) {
			this.exp = exp;
		}
		public String getCert_source() {
			return cert_source;
		}
		public void setCert_source(String cert_source) {
			this.cert_source = cert_source;
		}
		public EmployeeSkill(EmpID id, Login_det login_det, Skills skills, String proficiency, String exp,
				String cert_source) {
			super();
			this.id = id;
			this.login_det = login_det;
			this.skills = skills;
			this.proficiency = proficiency;
			this.exp = exp;
			this.cert_source = cert_source;
		}
		public EmployeeSkill() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
		
		
		
		

}
