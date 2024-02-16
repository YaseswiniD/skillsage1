package com.example.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable
public class EmpID implements Serializable{
		
		  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		@Column(name = "empid")
		private String empid;
		
		
		@Column(name = "skillid")
	    private Integer skillid;
		

		


		public String getEmpid() {
			return empid;
		}


		public void setEmpid(String empid) {
			this.empid = empid;
		}


		public Integer getSkillid() {
			return skillid;
		}


		public void setSkillid(Integer skillid) {
			this.skillid = skillid;
		}


		public static long getSerialversionuid() {
			return serialVersionUID;
		}


	

		public EmpID(String empid, Integer skillid) {
			super();
			this.empid = empid;
			this.skillid = skillid;
			
		}


		public EmpID() {
			super();
			// TODO Auto-generated constructor stub
		}


		
		
		   
	}



