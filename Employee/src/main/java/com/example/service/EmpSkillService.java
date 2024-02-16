package com.example.service;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.EmployeeSkill;
import com.example.entity.Skills;
//import com.example.entity.User;
import com.example.logrepo.logRepository;
import com.example.repository.Empskillrepo;
import com.example.repository.Skillrepo;
//import com.example.repository.Userrepo;

//import jakarta.transaction.Transactional;

import com.example.entity.EmpID;

@Service
public class EmpSkillService {
	
	@Autowired
	private Empskillrepo repos;

	    
	 @Autowired
	    public EmpSkillService(Empskillrepo empSkillRepo) {
	        this.repos = empSkillRepo;
	    }
	    public void saveEmpSkill(EmployeeSkill Eskill) {
			 repos.save(Eskill);
		}
	    
	public EmployeeSkill saveEmpSkill1(EmployeeSkill Eskill) {
		return repos.save(Eskill);
	}
	
	public List<EmployeeSkill> saveEmpSkills(List<EmployeeSkill> Eskill) {
		return repos.saveAll(Eskill);
	}
	public List<EmployeeSkill> getEmpSkills(){
		return repos.findAll();
	}
	
	
   
    
    public List<EmployeeSkill> getEmpSkillsByEmpId(String empId) {
        return repos.findById_Empid(empId);
    }

    
    public void deleteEmpSkill(String empid, Integer skillid) {
        EmpID empID = new EmpID(empid, skillid);
        Optional<EmployeeSkill> empSkillOptional = repos.findById(empID);

        empSkillOptional.ifPresent(empSkill -> {
            repos.delete(empSkill);
        });
    }

    


    public EmployeeSkill getEmpSkillById(String empId, Integer skillId) {
        return repos.findById(new EmpID(empId, skillId)).orElse(null);
    }


    public void updateEmpSkill(String empId, Integer skillId, String proficiency, String exp, String certSource) {
        EmpID empID = new EmpID(empId, skillId);
        EmployeeSkill empSkill = repos.findById(empID).orElse(null);
        if (empSkill != null) {
            empSkill.setProficiency(proficiency);
            empSkill.setExp(exp);
            empSkill.setCert_source(certSource);
         repos.save(empSkill);
        }
    }
    @Transactional
    public void deleteEmpSkillByEmpId(String empId) {
        // Retrieve related records by empId
        List<EmployeeSkill> empSkills = repos.findById_Empid(empId);
        
        // Delete each related record
        for(EmployeeSkill empSkill : empSkills) {
            repos.delete(empSkill);
        }
    }
}
